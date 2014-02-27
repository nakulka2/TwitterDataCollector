package com.twitter;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.*;

public class UI extends JFrame {

	/**
	 * A Simple Swing UI accepting 
	 * user credentials, 
	 * job start time, 
	 * job end time, 
	 * local file path where the streams must be stored.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel startTimeLabel;
	private JLabel endTimeLabel;
	private JLabel apiKeyLabel;
	private JLabel apiSecretLabel;
	private JLabel accessTokenLabel;
	private JLabel accessTokenSecretLabel;
	private JLabel filterLabel;
	private JLabel filePathLabel;
	private JTextField startTimeTextField;
	private JTextField endTimeTextField;
	private JTextField apiKeyTextField;
	private JTextField apiSecretTextField;
	private JTextField accessTokenTextField;
	private JTextField accessTokenSecretTextField;
	private JTextField filterTextField;
	private JTextField filePathTextField;
	private JButton scheduleButton;
	private JPanel contentPane;

	public UI() {
		super();
		create();
		this.setVisible(true);
	}

	private void create() {
		startTimeLabel = new JLabel();
		endTimeLabel = new JLabel();
		apiKeyLabel = new JLabel();
		apiSecretLabel = new JLabel();
		accessTokenLabel = new JLabel();
		accessTokenSecretLabel = new JLabel();
		filterLabel = new JLabel();
		filePathLabel = new JLabel();
		startTimeTextField = new JTextField();
		endTimeTextField = new JTextField();
		apiKeyTextField = new JTextField();
		apiSecretTextField = new JTextField();
		accessTokenTextField = new JTextField();
		accessTokenSecretTextField = new JTextField();
		filterTextField = new JTextField();
		filePathTextField = new JTextField();
		scheduleButton = new JButton();
		contentPane = (JPanel) this.getContentPane();

		startTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		startTimeLabel.setForeground(new Color(0, 0, 255));
		startTimeLabel.setText("Start Time in MMM dd, yyyy HH:mm:ss");

		endTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		endTimeLabel.setForeground(new Color(0, 0, 255));
		endTimeLabel.setText("End Time in MMM dd, yyyy HH:mm:ss");

		apiKeyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		apiKeyLabel.setForeground(new Color(0, 0, 255));
		apiKeyLabel.setText("Api Key");

		apiSecretLabel.setHorizontalAlignment(SwingConstants.LEFT);
		apiSecretLabel.setForeground(new Color(0, 0, 255));
		apiSecretLabel.setText("Api Secret");

		accessTokenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		accessTokenLabel.setForeground(new Color(0, 0, 255));
		accessTokenLabel.setText("Token");
		
		accessTokenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		accessTokenLabel.setForeground(new Color(0, 0, 255));
		accessTokenLabel.setText(" Access Token");
		
		accessTokenSecretLabel.setHorizontalAlignment(SwingConstants.LEFT);
		accessTokenSecretLabel.setForeground(new Color(0, 0, 255));
		accessTokenSecretLabel.setText(" Access Token Secret");

		filterLabel.setHorizontalAlignment(SwingConstants.LEFT);
		filterLabel.setForeground(new Color(0, 0, 255));
		filterLabel.setText("Enter keyword filters (comma separated)");

		filePathLabel.setHorizontalAlignment(SwingConstants.LEFT);
		filePathLabel.setForeground(new Color(0, 0, 255));
		filePathLabel.setText("Enter local file path");

		startTimeTextField.setForeground(new Color(0, 0, 255));
		startTimeTextField.setSelectedTextColor(new Color(0, 0, 255));

		endTimeTextField.setForeground(new Color(0, 0, 255));
		endTimeTextField.setSelectedTextColor(new Color(0, 0, 255));

		apiKeyTextField.setForeground(new Color(0, 0, 255));
		apiKeyTextField.setSelectedTextColor(new Color(0, 0, 255));

		apiSecretTextField.setForeground(new Color(0, 0, 255));
		apiSecretTextField.setSelectedTextColor(new Color(0, 0, 255));

		accessTokenTextField.setForeground(new Color(0, 0, 255));
		accessTokenTextField.setSelectedTextColor(new Color(0, 0, 255));

		accessTokenSecretTextField.setForeground(new Color(0, 0, 255));
		accessTokenSecretTextField.setSelectedTextColor(new Color(0, 0, 255));

		filterTextField.setForeground(new Color(0, 0, 255));
		filterTextField.setSelectedTextColor(new Color(0, 0, 255));

		filePathTextField.setForeground(new Color(0, 0, 255));
		filePathTextField.setSelectedTextColor(new Color(0, 0, 255));

		scheduleButton.setBackground(new Color(204, 204, 204));
		scheduleButton.setForeground(new Color(0, 0, 255));
		scheduleButton.setText("Schedule Job");
		scheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButton1_actionPerformed(e);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setBackground(new Color(204, 204, 204));
		addComponent(contentPane, startTimeLabel, 5, 10, 450, 18);
		addComponent(contentPane, endTimeLabel, 5, 47, 450, 18);
		addComponent(contentPane, apiKeyLabel, 5, 84, 450, 18);
		addComponent(contentPane, apiSecretLabel, 5, 121, 450, 18);
		addComponent(contentPane, accessTokenLabel, 5, 158, 450, 18);
		addComponent(contentPane, accessTokenSecretLabel, 5, 195, 450, 18);
		addComponent(contentPane, filterLabel, 5, 232, 450, 18);
		addComponent(contentPane, filePathLabel, 5, 269, 450, 18);
		addComponent(contentPane, startTimeTextField, 250, 10, 480, 22);
		addComponent(contentPane, endTimeTextField, 250, 47, 480, 22);
		addComponent(contentPane, apiKeyTextField, 250, 84, 480, 22);
		addComponent(contentPane, apiSecretTextField, 250, 121, 480, 22);
		addComponent(contentPane, accessTokenTextField, 250, 158, 480, 22);
		addComponent(contentPane, accessTokenSecretTextField, 250, 195, 480, 22);
		addComponent(contentPane, filterTextField, 250, 232, 480, 22);
		addComponent(contentPane, filePathTextField, 250, 269, 480, 22);
		addComponent(contentPane, scheduleButton, 250, 300, 120, 28);
		//
		// Twitter Data Collector
		//
		this.setTitle("TwitterDataCollector");
		this.setLocation(new Point(76, 182));
		this.setSize(new Dimension(800, 380));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(true);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container, Component c, int x, int y,
			int width, int height) {
		c.setBounds(x, y, width, height);
		container.add(c);
	}

	private void jButton1_actionPerformed(ActionEvent e) throws ParseException,
			InterruptedException {

		SimpleDateFormat formatter = new SimpleDateFormat(
				"MMM dd, yyyy HH:mm:ss");
		Context.START_TIME = formatter.parse(startTimeTextField.getText());
		Context.END_TIME = formatter.parse(endTimeTextField.getText());
		Context.API_KEY = apiKeyTextField.getText();
		Context.API_SECRET = apiSecretTextField.getText();
		Context.ACCESS_TOKEN = accessTokenTextField.getText();
		Context.ACCESS_TOKEN_SECRET = accessTokenSecretTextField.getText();
		Context.FILTER=filterTextField.getText().split(",");
		Context.FILE_PATH = filePathTextField.getText();

		dispose();

		JOptionPane
				.showMessageDialog(
						contentPane,
						"<HTML><FONT COLOR = Green>Congrats!</FONT><BR><FONT COLOR = Blue> Your job is scheduled at "
								+ Context.START_TIME
								+ "<BR> Your twitter data will be available at "
								+ Context.FILE_PATH
								+ " at "
								+ Context.END_TIME
								+ "<BR><BR></FONT><FONT COLOR = Red>NOTE:</FONT><BR><FONT COLOR = Blue> Please copy this information.<BR> However leave the command prompt running</FONT></HTML>");

		JobRunner runner = new JobRunner();
		runner.runJob();
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new UI();
	};
}