/**
 * @author tiago
 * 
 */

var webSocket;

function openSocket() {

	if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
		return;
	}

	webSocket = new WebSocket("ws://localhost:8080/smtl-web-manager/echo");
	// webSocket = new WebSocket("ws://localhost:8080/manager/echo");

	webSocket.onopen = function(event) {
		if (event.data === undefined) {
			return;
		}
	};

	webSocket.onmessage = function(evt) {
		var data = evt.data.split(":");
		document.getElementById(data[0]).value = data[1];
	};
}

window.onload = openSocket;
window.onbeforeunload = closeSocket;

function closeSocket() {
	webSocket.close();
}

function closeSocket() {
	webSocket.close();
}

function send(btn) {
	webSocket.send(btn.id + ":" + btn.value);
}