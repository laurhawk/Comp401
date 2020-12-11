package sushigame.view;

import java.awt.font.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import comp401sushi.AvocadoPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Plate;
import comp401sushi.Roll;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver, ActionListener {

	private Belt belt;
	private JButton[] belt_buttons;
	private JOptionPane popup;
	private String message;

	// array of j button, when you click button new pop up window
	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_buttons = new JButton[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JButton pbutton = new JButton("");
			pbutton.setMinimumSize(new Dimension(300, 20));
			pbutton.setPreferredSize(new Dimension(300, 20));
			pbutton.setOpaque(true);
			pbutton.setBackground(Color.WHITE);
			pbutton.setActionCommand(Integer.toString(i));
			pbutton.addActionListener(this);
			add(pbutton);
			belt_buttons[i] = pbutton;

		}
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	public String whatIsOnPlate(int position) {
		String type = "";
		String ingredients = "";
		String chef = "";
		String age = "";
		String color = "";
		IngredientPortion[] roll_ings = { new AvocadoPortion(10) };
		Roll placement_roll = new Roll("avocado", roll_ings);
		String message;

		if (belt.getPlateAtPosition(position) != null) {
			if (belt.getPlateAtPosition(position).getContents().getClass() == placement_roll.getClass()) {
				int roll_amount = belt.getPlateAtPosition(position).getContents().getIngredients().length;
				String roll_ingredients = "";
				for (int i = 0; i < roll_amount; i++) {
					roll_ingredients += "* "
							+ Double.toString(
									belt.getPlateAtPosition(position).getContents().getIngredients()[i].getAmount())
							+ " ounces of " + belt.getPlateAtPosition(position).getContents().getIngredients()[i]
									.getIngredient().getName()
							+ "\n";
				}
				type = belt.getPlateAtPosition(position).getContents().getName();
				ingredients = roll_ingredients;
			}
			if (belt.getPlateAtPosition(position).getContents().getName().contains("sashimi")) {
				type = belt.getPlateAtPosition(position).getContents().getName();
				if (belt.getPlateAtPosition(position).getContents().getName().contains("crab")) {
					ingredients = "crab";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("eel")) {
					ingredients = "eel";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("shrimp")) {
					ingredients = "shrimp";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("tuna")) {
					ingredients = "tuna";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("yellowtail")) {
					ingredients = "yellowtail";
				}
				ingredients = ingredients;

			} else if (belt.getPlateAtPosition(position).getContents().getName().contains("nigiri")) {
				type = belt.getPlateAtPosition(position).getContents().getName();
				if (belt.getPlateAtPosition(position).getContents().getName().contains("crab")) {
					ingredients = "crab";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("eel")) {
					ingredients = "eel";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("shrimp")) {
					ingredients = "shrimp";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("tuna")) {
					ingredients = "tuna";
				}
				if (belt.getPlateAtPosition(position).getContents().getName().contains("yellowtail")) {
					ingredients = "yellowtail";
				}
				ingredients = ingredients + " and rice";
			}
		}
		if (belt.getPlateAtPosition(position) != null) {
			switch (belt.getPlateAtPosition(position).getColor()) {
			case RED:
				color = "red";
				break;
			case GREEN:
				color = "green";
				break;
			case BLUE:
				color = "blue";
			case GOLD:
				color = "gold";
				break;
			}
		}
		chef = belt.getPlateAtPosition(position).getChef().getName();
		age = Integer.toString(belt.getAgeOfPlateAtPosition(position));

		message = "Type of Sushi: " + type + "\n" + "Ingredients: " + ingredients + "\n"
				+ "Chef: " + chef + "\n" + "Age: " + age;

		return message;
	}

	private void refresh() {
		for (int i = 0; i < belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JButton pbutton = belt_buttons[i];

			if (p == null) {
				for (ActionListener button_variable : pbutton.getActionListeners()) {
					pbutton.removeActionListener(button_variable);
				}
				pbutton.setText("");
				pbutton.setBackground(Color.BLACK);
				

			} else {
				Plate pl = belt.getPlateAtPosition(i);
				for (ActionListener button_variable : pbutton.getActionListeners()) {
					pbutton.removeActionListener(button_variable);
				}
				
				switch (pl.getColor()) {
				case RED:
					pbutton.setBackground(Color.RED);
					pbutton.setForeground(Color.RED);
					break;
				case GREEN:
					pbutton.setBackground(Color.GREEN);
					pbutton.setForeground(Color.GREEN);
					break;
				case BLUE:
					pbutton.setBackground(Color.BLUE);
					pbutton.setForeground(Color.BLUE);
					break;
				case GOLD:
					pbutton.setBackground(Color.YELLOW);
					pbutton.setForeground(Color.YELLOW);
					break;
				}
				pbutton.setText("Click for Sushi Info");
				pbutton.setFont(new Font("TimesRoman", Font.BOLD, 15));

				pbutton.addActionListener(this);


				
			
			}
		}
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		int i = Integer.parseInt(e.getActionCommand());
		String info = whatIsOnPlate(i);
		JOptionPane information = new JOptionPane(info);
		frame.add(information);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setVisible(true);
	}
}
