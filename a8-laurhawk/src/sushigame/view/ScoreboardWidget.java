package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import comp401sushi.Sushi;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.HighToLowSold;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;

	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);

		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		display.setText(makeScoreboardHTML());
		display.setText(makeFoodSoldHTML());
		display.setText(makeFoodSpoiledHTML());

		JButton profit_button = new JButton("Balance");
		profit_button.setActionCommand("profit");
		profit_button.addActionListener(this);
		display.add(profit_button);
		profit_button.setBounds(25, 200, 90, 30);

		JButton sold_button = new JButton("Sold");
		sold_button.setActionCommand("sold");
		sold_button.addActionListener(this);
		display.add(sold_button);
		sold_button.setBounds(25, 225, 90, 30);

		JButton spoiled_button = new JButton("Spoiled");
		spoiled_button.setActionCommand("spoiled");
		spoiled_button.addActionListener(this);
		display.add(spoiled_button);
		spoiled_button.setBounds(25, 250, 90, 30);

	}

	private String makeScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Chef Balance</h1>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs = game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length + 1];
		chefs[0] = game_model.getPlayerChef();
		for (int i = 1; i < chefs.length; i++) {
			chefs[i] = opponent_chefs[i - 1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());

		for (Chef c : chefs) {
			sb_html += c.getName() + " ($" + Math.round(c.getBalance() * 100.0) / 100.0 + ") <br>";
		}
		return sb_html;
	}

	private String makeFoodSoldHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Food Sold</h1>";

		// Create an array of all chefs and sort by food sold.
		Chef[] opponent_chefs = game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length + 1];
		chefs[0] = game_model.getPlayerChef();
		for (int i = 1; i < chefs.length; i++) {
			chefs[i] = opponent_chefs[i - 1];
		}
		Arrays.sort(chefs, new HighToLowSold());

		for (Chef c : chefs) {
			sb_html += c.getName() + " ($" + Math.round(c.foodConsumed() * 100.0) / 100.0 + ") <br>";
		}
		return sb_html;
	}

	private String makeFoodSpoiledHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Food Spoiled</h1>";

		// Create an array of all chefs and sort by food spoiled.
		Chef[] opponent_chefs = game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length + 1];
		chefs[0] = game_model.getPlayerChef();
		for (int i = 1; i < chefs.length; i++) {
			chefs[i] = opponent_chefs[i - 1];
		}
		Arrays.sort(chefs, new LowToHighSpoiled());

		for (Chef c : chefs) {
			sb_html += c.getName() + " (" + Math.round(c.foodSpoiled() * 100.0) / 100.0 + " oz.) <br>";
		}
		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());
		display.setText(makeFoodSoldHTML());
		display.setText(makeFoodSpoiledHTML());
	
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "profit":
			display.setText(makeScoreboardHTML());
			break;
		case "sold":
			display.setText(makeFoodSoldHTML());
			break;
		case "spoiled":
			display.setText(makeFoodSpoiledHTML());
		}
	}
}
