package br.si.es.sga.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MessageUtil {
	public static void addMsg(Component component ,String msg){
		JOptionPane.showMessageDialog(component, msg );
	}
}
