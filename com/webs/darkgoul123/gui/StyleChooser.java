package com.webs.darkgoul123.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.webs.darkgoul123.Loop;
import com.webs.darkgoul123.interfaces.GuiImpl;

@SuppressWarnings("serial")
public class StyleChooser extends JFrame implements ActionListener, GuiImpl {

	private JButton afkButton = new JButton();
	private JButton attackButton = new JButton();

	public StyleChooser() {
		afkButton.setText("AFK");
		attackButton.setText("Attack");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Style of Play");
		setBounds(getLocX(), getLocY(), 0, 0);
		afkButton.addActionListener(this);
		attackButton.addActionListener(this);
		add(afkButton, BorderLayout.WEST);
		add(attackButton, BorderLayout.EAST);
		pack();
	}

	public int getLocX() {
		return getToolkit().getScreenSize().width / 2;
	}

	public int getLocY() {
		return getToolkit().getScreenSize().height / 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(afkButton)) {
			Loop.s = Loop.Style.AFK;
		} else {
			Loop.s = Loop.Style.ATTACK;
		}
		setVisible(false);
	}

}
