package br.com.fotosensores.websocket;

import java.io.BufferedReader;
import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import br.com.fotosensores.dao.ServiceDAO;
import br.com.fotosensores.model.Service;
import br.com.fotosensores.util.Util;

/**
 * @author tiago
 *
 */
@ServerEndpoint("/echo")
public class ServiceStatusWebSocket {

	private ServiceDAO dao = new ServiceDAO();

	@OnOpen
	public void onOpen(Session session) {
		checkStatus(session);
	}

	@OnMessage
	public void onMessage(String message, Session session) {

		String[] token = message.split(":");
		Long id = Long.valueOf(token[0].split("-")[1]);

		Service service = dao.findServiceById(id);
		String path = service.getPath();

		String[] cmd = { "sudo", path, token[1] };
		try {
			Util.executeCommand(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getServiceStatus(Service service) {
		String path = service.getPath();
		String status = null;

		String[] cmdarray = { path, "status" };
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = Util.executeCommand(cmdarray);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.charAt(0) == '0') {
					status = "start";
				} else {
					status = "stop";
				}
				System.err.println(status);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "btn-" + service.getId() + ":" + status;
	}

	private void checkStatus(Session session) {
		new Thread(new Runnable() {
			public void run() {
				while (session.isOpen()) {
					for (Service service : dao.listAllServices()) {
						try {
							String serviceStatus = getServiceStatus(service);
							session.getBasicRemote().sendText(serviceStatus);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
