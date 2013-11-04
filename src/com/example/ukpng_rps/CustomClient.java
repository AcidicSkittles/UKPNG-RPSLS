package com.example.ukpng_rps;

import java.io.IOException;
import java.net.UnknownHostException;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.example.javaclient.Client;

public class CustomClient extends Client{
WebView field;
	public CustomClient(int port, String ip, String playerName)
			throws UnknownHostException, IOException {
		super(port, ip, playerName);
	}
	//custom constructor that takes an additional webview param
	public CustomClient(int port, String ip, String playerName, WebView param)
			throws UnknownHostException, IOException {
		super(port, ip, playerName);
		this.field = param;
	}
	@Override
	protected void displayWinner(Integer winner) {
		super.displayWinner(winner);
		field.getSettings().setJavaScriptEnabled(true); // unless you set this true elsewhere then its fine
        field.loadUrl("file:///android_asset/html.html the file location of the html");
        field.loadUrl("javascript:displayWinner("+winner+")");
	}
	@Override
	protected void displayPlayerNames() {
		super.displayPlayerNames();
		field.getSettings().setJavaScriptEnabled(true); // unless you set this true elsewhere then its fine
        field.loadUrl("file:///android_asset/html.html the file location of the html");
        field.loadUrl("javascript:displayPlayerNames()");;
	}
	@Override
	protected void displayScores(){
		super.displayScores();
		field.getSettings().setJavaScriptEnabled(true); // unless you set this true elsewhere then its fine
        field.loadUrl("file:///android_asset/html.html the file location of the html");
        field.loadUrl("javascript:displayScores()");
	}
	@JavascriptInterface
	public void sendMove(String move){
		super.sendMove(move);
	}
}
