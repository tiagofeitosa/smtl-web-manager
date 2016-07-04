package br.com.fotosensores.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.fotosensores.dao.ServiceDAO;
import br.com.fotosensores.model.Service;
import br.com.fotosensores.util.Util;

public class InitServicesListener implements ServletContextListener {

	private ServiceDAO dao = new ServiceDAO();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		for (Service service : dao.listAllServices()) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					String[] cmd = { "sudo", service.getPath(), "start" };
					try {
						Util.executeCommand(cmd);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			});
			t.start();
		}
	}

}
