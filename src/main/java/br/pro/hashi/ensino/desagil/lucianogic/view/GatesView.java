package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;
import br.pro.hashi.ensino.desagil.lucianogic.model.Switch;



// Esta classe representa a interface de uma calculadora de densidade, com
// os dois campos de entrada (peso e raio) e o campo de saida (resultado).
public class GatesView extends FixedPanel implements ItemListener, ActionListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;

	private Image image;
	
	private JButton button;

	// A componente JTextField representa um campo para digitacao de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	private	JCheckBox inputBoxA;
	private	JCheckBox inputBoxB;
	private	JCheckBox inputBoxC;
	private	JCheckBox outputBox;
	
	private Switch buttonA;
	private Switch buttonB;
	private Switch buttonC;
	
	private Gate gate;

	public GatesView(Gate gate) {
		super(600, 360);
		this.gate = gate;
		int size = gate.getSize();
		
		image = loadImage(gate.toString());
		
		buttonA = new Switch();
		buttonB = new Switch();
		buttonC = new Switch();
		
		gate.connect(buttonA, 0);
		
		if(size == 2 || size == 3){
			gate.connect(buttonB, 1);
		}
		
		if(size == 3){
			gate.connect(buttonC, 2);
		}
		
		inputBoxA = new JCheckBox("A");
		inputBoxB = new JCheckBox("B");
		inputBoxC = new JCheckBox("Selector");
		
		JLabel selector = new JLabel("Selector");
		
		inputBoxA.addItemListener(this);
		inputBoxB.addItemListener(this);
		inputBoxC.addItemListener(this);
		
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(this);
		add(button, 438, 160, 40, 40);

		add(inputBoxA,40,118, 20, 20);
		add(inputBoxB,40,220, 20, 20);
		
		if(size == 2 || size == 3){
			add(inputBoxB,40,220, 20, 20);
		}
		else {
			remove(inputBoxB);
		}
		
		if(size == 3){
			add(inputBoxC,245,320, 20, 20);
			add(selector,270,320, 60, 20);
		}
		else {
			remove(inputBoxC);
		}
		
		add(button,438, 160, 40, 40);
		
		if(gate.read() == false){
			button.setEnabled(false);
		}
		if(gate.read() == true){
			button.setEnabled(true);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		if(source == inputBoxA){
			buttonA.setOn(inputBoxA.isSelected());
		}
		
		if(source == inputBoxB){
			buttonB.setOn(inputBoxB.isSelected());
		}
		
		if(source == inputBoxC){
			buttonC.setOn(inputBoxC.isSelected());
		}
		
		if(gate.read() == false){
			button.setEnabled(false);
		}
		
		if(gate.read() == true){
			button.setEnabled(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(this, null, null);
		if(color != null) {
			button.setBackground(color);
		}
	}
	
	// Necessario para carregar os arquivos de imagem.
	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}	

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 600, 360, null);

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
	}
}