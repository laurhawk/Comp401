package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import comp401sushi.AvocadoPortion;
import comp401sushi.CrabPortion;
import comp401sushi.EelPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Nigiri;
import comp401sushi.Plate;
import comp401sushi.Plate.Color;
import comp401sushi.RedPlate;
import comp401sushi.RicePortion;
import comp401sushi.Roll;
import comp401sushi.Sashimi;
import comp401sushi.SeaweedPortion;
import comp401sushi.ShrimpPortion;
import comp401sushi.Sushi;
import comp401sushi.TunaPortion;
import comp401sushi.YellowtailPortion;

public class PlayerChefView extends JPanel implements ActionListener, ChangeListener {

	private List<ChefViewListener> listeners;
	private Sushi kmp_roll;

	private Sushi type;

	private Sushi crab_sashimi;
	private Sushi eel_sashimi;
	private Sushi shrimp_sashimi;
	private Sushi tuna_sashimi;
	private Sushi yellowtail_sashimi;

	private Sushi crab_nigiri;
	private Sushi eel_nigiri;
	private Sushi shrimp_nigiri;
	private Sushi tuna_nigiri;
	private Sushi yellowtail_nigiri;

	private Color color_of_plate;

	private int belt_size;
	
	private String name_of_roll;
	
	private ArrayList<IngredientPortion> roll_ingredients;
	
	private IngredientPortion[] r_i;

	private JComboBox<String> plate_color;
	private JComboBox<String> sashi_sushi;
	private JComboBox<String> ni_sushi;

	private JSlider position;
	private JSlider plate_price;
	private JSlider avocado_selection;
	private double avo_amount;
	private JSlider crab_selection;
	private double crab_amount;
	private JSlider eel_selection;
	private double eel_amount;
	private JSlider rice_selection;
	private double rice_amount;
	private JSlider seaweed_selection;
	private double seaweed_amount;
	private JSlider shrimp_selection;
	private double shrimp_amount;
	private JSlider tuna_selection;
	private double tuna_amount;
	private JSlider yellowtail_selection;
	private double yellowtail_amount;

	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();
		// sets default plate color to red, the first choice
		color_of_plate = Color.RED;

		setLayout(new GridLayout(0, 2));

		// position slider
		JLabel position_title = new JLabel();
		add(position_title, BorderLayout.CENTER);
		position_title.setText("Position on Belt");
		position_title.setFont(new Font("TimesRoman", Font.BOLD, 15));
		position = new JSlider(1, 20, 1);
		position.setMajorTickSpacing(1);
		position.setPaintTicks(true);
		Hashtable<Integer, JLabel> index = new Hashtable<Integer, JLabel>();
		position.setPaintLabels(true);
		index.put(1, new JLabel("1"));
		index.put(10, new JLabel("10"));
		index.put(20, new JLabel("20"));
		position.setLabelTable(index);

		position.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				
			}
		});

		add(position);

		// plate slider
		JLabel plate_title = new JLabel();
		plate_title.setFont(new Font("TimesRoman", Font.BOLD, 15));
		add(plate_title);
		plate_title.setText("Color of Plate");

		String[] color_selection = { "Red", "Green", "Blue", "Gold" };

		plate_color = new JComboBox<String>(color_selection);
		plate_color.setVisible(true);

		plate_color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int color = plate_color.getSelectedIndex();
				switch (color) {
				case 0:
					color_of_plate = Color.RED;
					break;
				case 1:
					color_of_plate = Color.GREEN;
					break;
				case 2:
					color_of_plate = Color.BLUE;
					break;
				case 3:
					color_of_plate = Color.GOLD;
					break;

				}
			}
		});

		add(plate_color);

		// Gold plate price setter
		// I think that there is an error in Gold Plate, but I can't tell what it is
		JLabel gold_plate_price = new JLabel();
		add(gold_plate_price);
		gold_plate_price.setText("Gold Plate Price (if applicable)");
		gold_plate_price.setFont(new Font("TimesRoman", Font.BOLD, 15));
		plate_price = new JSlider(5, 10, 5);
		plate_price.setMajorTickSpacing(1);
		plate_price.setPaintTicks(true);
		Hashtable<Integer, JLabel> dollars = new Hashtable<Integer, JLabel>();
		plate_price.setPaintLabels(true);
		dollars.put(5, new JLabel("$5"));
		dollars.put(6, new JLabel("$6"));
		dollars.put(7, new JLabel("$7"));
		dollars.put(8, new JLabel("$8"));
		dollars.put(9, new JLabel("$9"));
		dollars.put(10, new JLabel("$10"));

		plate_price.setLabelTable(dollars);

		plate_price.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				
			}
		});

		add(plate_price);

		// Sashimi selection
		JLabel s_sushi = new JLabel();
		add(s_sushi);
		s_sushi.setFont(new Font("TimesRoman", Font.BOLD, 15));
		s_sushi.setText("Sashimi Selection");
		String[] sashimi_meat = { "None", "Crab", "Eel", "Shrimp", "Tuna", "Yellowtail" };

		sashi_sushi = new JComboBox<String>(sashimi_meat);
		sashi_sushi.setVisible(true);

		sashi_sushi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int sashimi_selection = sashi_sushi.getSelectedIndex();

				switch (sashimi_selection) {
				case 0:
					type = null;
					break;
				case 1:
					type = crab_sashimi;
					break;
				case 2:
					type = eel_sashimi;
					break;
				case 3:
					type = shrimp_sashimi;
					break;
				case 4:
					type = tuna_sashimi;
					break;
				case 5:
					type = yellowtail_sashimi;
					break;
				}

			}

		});
		add(sashi_sushi);

		// nigiri selection
		JLabel n_sushi = new JLabel();
		add(n_sushi);
		n_sushi.setFont(new Font("TimesRoman", Font.BOLD, 15));
		n_sushi.setText("Nigiri Selection");
		String[] nigiri_meat = { "None", "Crab", "Eel", "Shrimp", "Tuna", "Yellowtail" };
		ni_sushi = new JComboBox<String>(nigiri_meat);
		ni_sushi.setVisible(true);

		ni_sushi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nigiri_selection = ni_sushi.getSelectedIndex();

				switch (nigiri_selection) {
				case 0:
					type = null;
					break;
				case 1:
					type = crab_nigiri;
					break;
				case 2:
					type = eel_nigiri;
					break;
				case 3:
					type = shrimp_nigiri;
					break;
				case 4:
					type = tuna_nigiri;
					break;
				case 5:
					type = yellowtail_nigiri;
					break;
				}
			}
		});

		add(ni_sushi);

		// roll options
		JLabel r_sushi = new JLabel();
		add(r_sushi);
		r_sushi.setFont(new Font("TimesRoman", Font.BOLD, 15));
		r_sushi.setText("Roll Selection");
		JTextField roll_name = new JTextField("Name Your Roll");
		add(roll_name);
		name_of_roll = roll_name.getText();

		// public void actionPerformed(ActionEvent event) {
		// input = roll_name.getText(); // receive input from text field
		// System.out.println(input);
		// }

		JLabel amt_avocado = new JLabel();
		add(amt_avocado);
		amt_avocado.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		amt_avocado.setText("Ounces of Avocado");
		avocado_selection = new JSlider(0, 15, 00);
		avocado_selection.setMajorTickSpacing(1);
		avocado_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> avooz = new Hashtable<Integer, JLabel>();
		avocado_selection.setPaintLabels(true);
		avooz.put(0, new JLabel("0.0"));
		avooz.put(5, new JLabel("0.5"));
		avooz.put(10, new JLabel("1.0"));
		avooz.put(15, new JLabel("1.5"));
		avocado_selection.setLabelTable(avooz);

		avocado_selection.addChangeListener(this);

		add(avocado_selection);

		JLabel amt_crab = new JLabel();
		add(amt_crab);
		amt_crab.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		amt_crab.setText("Ounces of Crab");
		crab_selection = new JSlider(0, 15, 00);
		crab_selection.setMajorTickSpacing(1);
		crab_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> craboz = new Hashtable<Integer, JLabel>();
		crab_selection.setPaintLabels(true);
		craboz.put(0, new JLabel("0.0"));
		craboz.put(5, new JLabel("0.5"));
		craboz.put(10, new JLabel("1.0"));
		craboz.put(15, new JLabel("1.5"));
		crab_selection.setLabelTable(craboz);

		crab_selection.addChangeListener(this);

		add(crab_selection);

		JLabel amt_eel = new JLabel();
		amt_eel.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		add(amt_eel);
		amt_eel.setText("Ounces of Eel");
		eel_selection = new JSlider(0, 15, 00);
		eel_selection.setMajorTickSpacing(1);
		eel_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> eeloz = new Hashtable<Integer, JLabel>();
		eel_selection.setPaintLabels(true);
		eeloz.put(0, new JLabel("0.0"));
		eeloz.put(5, new JLabel("0.5"));
		eeloz.put(10, new JLabel("1.0"));
		eeloz.put(15, new JLabel("1.5"));
		eel_selection.setLabelTable(eeloz);

		eel_selection.addChangeListener(this);

		add(eel_selection);

		JLabel amt_rice = new JLabel();
		amt_rice.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		add(amt_rice);
		amt_rice.setText("Ounces of Rice");
		rice_selection = new JSlider(0, 15, 00);
		rice_selection.setMajorTickSpacing(1);
		rice_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> riceoz = new Hashtable<Integer, JLabel>();
		rice_selection.setPaintLabels(true);
		riceoz.put(0, new JLabel("0.0"));
		riceoz.put(5, new JLabel("0.5"));
		riceoz.put(10, new JLabel("1.0"));
		riceoz.put(15, new JLabel("1.5"));
		rice_selection.setLabelTable(riceoz);

		rice_selection.addChangeListener(this);

		add(rice_selection);

		JLabel amt_seaweed = new JLabel();
		amt_seaweed.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		add(amt_seaweed);
		amt_seaweed.setText("Ounces of Seaweed");
		seaweed_selection = new JSlider(0, 15, 00);
		seaweed_selection.setMajorTickSpacing(1);
		seaweed_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> seaweedoz = new Hashtable<Integer, JLabel>();
		seaweed_selection.setPaintLabels(true);
		seaweedoz.put(0, new JLabel("0.0"));
		seaweedoz.put(5, new JLabel("0.5"));
		seaweedoz.put(10, new JLabel("1.0"));
		seaweedoz.put(15, new JLabel("1.5"));
		seaweed_selection.setLabelTable(seaweedoz);

		seaweed_selection.addChangeListener(this);

		add(seaweed_selection);

		JLabel amt_shrimp = new JLabel();
		amt_shrimp.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		add(amt_shrimp);
		amt_shrimp.setText("Ounces of Shrimp");
		shrimp_selection = new JSlider(0, 15, 00);
		shrimp_selection.setMajorTickSpacing(1);
		shrimp_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> shrimpoz = new Hashtable<Integer, JLabel>();
		shrimp_selection.setPaintLabels(true);
		shrimpoz.put(0, new JLabel("0.0"));
		shrimpoz.put(5, new JLabel("0.5"));
		shrimpoz.put(10, new JLabel("1.0"));
		shrimpoz.put(15, new JLabel("1.5"));
		shrimp_selection.setLabelTable(shrimpoz);

		shrimp_selection.addChangeListener(this);

		add(shrimp_selection);

		JLabel amt_tuna = new JLabel();
		amt_tuna.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		add(amt_tuna);
		amt_tuna.setText("Ounces of Tuna");
		tuna_selection = new JSlider(0, 15, 00);
		tuna_selection.setMajorTickSpacing(1);
		tuna_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> tunaoz = new Hashtable<Integer, JLabel>();
		tuna_selection.setPaintLabels(true);
		tunaoz.put(0, new JLabel("0.0"));
		tunaoz.put(5, new JLabel("0.5"));
		tunaoz.put(10, new JLabel("1.0"));
		tunaoz.put(15, new JLabel("1.5"));
		tuna_selection.setLabelTable(tunaoz);

		tuna_selection.addChangeListener(this);

		add(tuna_selection);

		JLabel amt_yellowtail = new JLabel();
		amt_yellowtail.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		add(amt_yellowtail);
		amt_yellowtail.setText("Ounces of Yellowtail");
		yellowtail_selection = new JSlider(0, 15, 00);
		yellowtail_selection.setMajorTickSpacing(1);
		yellowtail_selection.setPaintTicks(true);
		Hashtable<Integer, JLabel> yellowtailoz = new Hashtable<Integer, JLabel>();
		yellowtail_selection.setPaintLabels(true);
		yellowtailoz.put(0, new JLabel("0.0"));
		yellowtailoz.put(5, new JLabel("0.5"));
		yellowtailoz.put(10, new JLabel("1.0"));
		yellowtailoz.put(15, new JLabel("1.5"));
		yellowtail_selection.setLabelTable(yellowtailoz);

		yellowtail_selection.addChangeListener(this);

		add(yellowtail_selection);

		// place my sushi button
//		JButton place_my_sushi = new JButton("Place My Sushi");
//		place_my_sushi.setActionCommand("place_sushi_on_belt");
//		place_my_sushi.addActionListener(this);
//		add(place_my_sushi);

		JButton make_sashimi = new JButton("Make Sashimi");
		make_sashimi.setActionCommand("make_sashimi");
		make_sashimi.addActionListener(this);
		add(make_sashimi);

		JButton make_nigiri = new JButton("Make Nigiri");
		make_nigiri.setActionCommand("make_sashimi");
		make_nigiri.addActionListener(this);
		add(make_nigiri);

		JButton make_roll = new JButton("Make Roll");
		make_roll.setActionCommand("make_sashimi");
		make_roll.addActionListener(this);
		add(make_roll);

//		JButton sashimi_button = new JButton("Make red plate of crab sashimi at position 3");
//		sashimi_button.setActionCommand("red_crab_sashimi_at_3");
//		sashimi_button.addActionListener(this);
//		add(sashimi_button);
//
//		JButton nigiri_button = new JButton("Make blue plate of eel nigiri at position 8");
//		nigiri_button.setActionCommand("blue_eel_nigiri_at_8");
//		nigiri_button.addActionListener(this);
//		add(nigiri_button);
//
//		JButton roll_button = new JButton("Make gold plate of KMP roll at position 5");
//		roll_button.setActionCommand("gold_kmp_roll_at_5");
//		roll_button.addActionListener(this);
//		add(roll_button);

		kmp_roll = new Roll("KMP Roll",
				new IngredientPortion[] { new EelPortion(1.0), new AvocadoPortion(0.5), new SeaweedPortion(0.2) });

		crab_sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
		eel_sashimi = new Sashimi(Sashimi.SashimiType.EEL);
		shrimp_sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
		tuna_sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
		yellowtail_sashimi = new Sashimi(Sashimi.SashimiType.YELLOWTAIL);

		crab_nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		eel_nigiri = new Nigiri(Nigiri.NigiriType.EEL);
		shrimp_nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
		tuna_nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
		yellowtail_nigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<IngredientPortion> roll_ingredients = new ArrayList<>();
		
		
		switch (e.getActionCommand()) {
		// position.disable(); can disable certain selections
//		case "place_sushi_on_belt":
//			switch (color_of_plate) {
//			case RED:
//				makeRedPlateRequest(type, position.getValue() - 1);
//				break;
//			case GREEN:
//				makeGreenPlateRequest(type, position.getValue() - 1);
//				break;
//			case BLUE:
//				makeBluePlateRequest(type, position.getValue() - 1);
//				break;
//			case GOLD:
//				makeGoldPlateRequest(type, position.getValue() - 1, plate_price.getValue());
//				break;
//			}
//			break;
		case "make_sashimi":
			String sashimi_type = (String) sashi_sushi.getSelectedItem();
			if (sashimi_type == "none") {
				type = null;
			}
			if (sashimi_type == "crab") {
				type = crab_sashimi;
			}
			if (sashimi_type == "eel") {
				type = eel_sashimi;
			}
			if (sashimi_type == "shrimp") {
				type = shrimp_sashimi;
			}
			if (sashimi_type == "tuna") {
				type = tuna_sashimi;
			}
			if (sashimi_type == "yellowtail") {
				type = yellowtail_sashimi;
			}
			switch (color_of_plate) {
			case RED:
				makeRedPlateRequest(type, position.getValue() - 1);
				break;
			case GREEN:
				makeGreenPlateRequest(type, position.getValue() - 1);
				break;
			case BLUE:
				makeBluePlateRequest(type, position.getValue() - 1);
				break;
			case GOLD:
				makeGoldPlateRequest(type, position.getValue() - 1, plate_price.getValue());
				break;
		}
			break;

		case "make_nigiri":
			String nigiri_type = (String) ni_sushi.getSelectedItem();
			if (nigiri_type == "none") {
				type = null;
			}
			if (nigiri_type == "crab") {
				type = crab_nigiri;
			}
			if (nigiri_type == "eel") {
				type = eel_nigiri;
			}
			if (nigiri_type == "shrimp") {
				type = shrimp_nigiri;
			}
			if (nigiri_type == "tuna") {
				type = tuna_nigiri;
			}
			if (nigiri_type == "yellowtail") {
				type = yellowtail_nigiri;
			}
			switch (color_of_plate) {
			case RED:
				makeRedPlateRequest(type, position.getValue() - 1);
				break;
			case GREEN:
				makeGreenPlateRequest(type, position.getValue() - 1);
				break;
			case BLUE:
				makeBluePlateRequest(type, position.getValue() - 1);
				break;
			case GOLD:
				makeGoldPlateRequest(type, position.getValue() - 1, plate_price.getValue());
				break;
		}
			break;
		case "make_roll":
			IngredientPortion[] r_i = roll_ingredients.toArray(new IngredientPortion[roll_ingredients.size()]);
			type = new Roll(name_of_roll, r_i);
			switch (color_of_plate) {
			case RED:
				makeRedPlateRequest(type, position.getValue() - 1);
				break;
			case GREEN:
				makeGreenPlateRequest(type, position.getValue() - 1);
				break;
			case BLUE:
				makeBluePlateRequest(type, position.getValue() - 1);
				break;
			case GOLD:
				makeGoldPlateRequest(type, position.getValue() - 1, plate_price.getValue());
				break;
			
			}
		}
		
		
			
			//type.getName() = name_of_roll;
			
//		case "red_crab_sashimi_at_3":
//			makeRedPlateRequest(crab_sashimi, 3);
//			break;
//		case "blue_eel_nigiri_at_8":
//			makeBluePlateRequest(eel_nigiri, 8);
//			break;
//		case "gold_kmp_roll_at_5":
//			makeGoldPlateRequest(kmp_roll, 5, 5.00);
//			break;
		
			

//			switch (color_of_plate) {
//			case RED:
//				makeRedPlateRequest(type, position.getValue() - 1);
//				break;
//			case GREEN:
//				makeGreenPlateRequest(type, position.getValue() - 1);
//				break;
//			case BLUE:
//				makeBluePlateRequest(type, position.getValue() - 1);
//				break;
//			case GOLD:
//				makeGoldPlateRequest(type, position.getValue() - 1, plate_price.getValue());
//				break;
//		}
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		avo_amount = avocado_selection.getValue()/10;
		crab_amount = crab_selection.getValue()/10;
		eel_amount = eel_selection.getValue()/10;
		rice_amount = rice_selection.getValue()/10;
		seaweed_amount = seaweed_selection.getValue()/10;
		shrimp_amount = shrimp_selection.getValue()/10;
		tuna_amount = tuna_selection.getValue()/10;
		yellowtail_amount = yellowtail_selection.getValue()/10;
		roll_ingredients.add(new AvocadoPortion(avo_amount));
		roll_ingredients.add(new CrabPortion(crab_amount));
		roll_ingredients.add(new EelPortion(eel_amount));
		roll_ingredients.add(new RicePortion(rice_amount));
		roll_ingredients.add(new SeaweedPortion(seaweed_amount));
		roll_ingredients.add(new ShrimpPortion(shrimp_amount));
		roll_ingredients.add(new TunaPortion(tuna_amount));
		roll_ingredients.add(new YellowtailPortion(yellowtail_amount));
		
	}
}
