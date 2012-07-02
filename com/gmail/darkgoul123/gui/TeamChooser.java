package com.gmail.darkgoul123.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.gmail.darkgoul123.Loop;
import com.gmail.darkgoul123.interfaces.GuiImpl;


@SuppressWarnings("serial")
public class TeamChooser extends JFrame implements ActionListener, GuiImpl {

	private JButton guthixButton = new JButton();
	private JButton saraButton = new JButton();
	private JButton zammyButton = new JButton();

	public TeamChooser() {
		guthixButton.setText("Guthix");
		saraButton.setText("Saradomin");
		zammyButton.setText("Zamorak");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Choose your team");
		setBounds(getLocX(), getLocY(), 0, 0);
		guthixButton.addActionListener(this);
		saraButton.addActionListener(this);
		zammyButton.addActionListener(this);
		add(guthixButton, BorderLayout.WEST);
		add(saraButton, BorderLayout.CENTER);
		add(zammyButton, BorderLayout.EAST);
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
		if(e.getSource().equals(guthixButton)) {
			Loop.t = Loop.Team.GUTHIX;
		} else if(e.getSource().equals(saraButton)) {
			Loop.t = Loop.Team.SARADOMIN;
		} else {
			Loop.t = Loop.Team.ZAMORAK;
		}
		setVisible(false);
		new StyleChooser().setVisible(true);
	}

}