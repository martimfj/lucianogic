package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;
import br.pro.hashi.ensino.desagil.lucianogic.model.Switch;
import br.pro.hashi.ensino.desagil.lucianogic.model.LED;

// Esta classe representa a interface gráfica de um simulador de portas lógicas
// há dois campos de entrada (A e B) e a saída, que se positiva, acende um LED.
public class GatesView extends FixedPanel implements ItemListener, ActionListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;

	private Image image;
	
	private LED output;
	
	private JButton button;

	private	JCheckBox inputBoxA;
	private	JCheckBox inputBoxB;
	private	JCheckBox inputBoxC;
	
	private Switch buttonA;
	private Switch buttonB;
	private Switch buttonC;
	
	private Color ledColor;
	
	private Gate gate;

	public GatesView(Gate gate) {
		super(600, 360);
		this.gate = gate;
		int size = gate.getSize();
		
		this.output = new LED(255, 255, 255);
		output.connect(gate, 0);
		
		image = loadImage(gate.toString());
		
		buttonA = new Switch();
		buttonB = new Switch();
		buttonC = new Switch();
		
		ledColor = Color.WHITE;
		
		gate.connect(buttonA, 0);
		
		if(size == 2 || size == 3){
			gate.connect(buttonB, 1);
		}
		
		if(size == 3){
			gate.connect(buttonC, 2);
		}
		
		//Checkbox A, B e Selector
		inputBoxA = new JCheckBox("A");
		inputBoxB = new JCheckBox("B");
		inputBoxC = new JCheckBox("Selector");
		
		JLabel selector = new JLabel("Selector");
		
		//Checkbox A, B e Selector sendo ouvidos
		inputBoxA.addItemListener(this);
		inputBoxB.addItemListener(this);
		inputBoxC.addItemListener(this);
		
		//Botão LED
		button = new JButton();
		button.addActionListener(this);
		button.setBackground(null);
		button.setOpaque(true);
	    button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		
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
		
		if(output.isOn() == false){
			button.setEnabled(false);
		}
		if(output.isOn() == true){
			add(button, 525, 166, 30, 30);
			button.setEnabled(true);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		if(source == inputBoxA){
			buttonA.setOn(inputBoxA.isSelected());
			button.setEnabled(false);
		}
		
		if(source == inputBoxB){
			buttonB.setOn(inputBoxB.isSelected());
			
		}
		
		if(source == inputBoxC){
			buttonC.setOn(inputBoxC.isSelected());
		}
		
		if(gate.read() == false){
			button.setEnabled(false);
			ledColor = null;
		}
		
		if(gate.read() == true){
			add(button, 525, 166, 30, 30);
			button.setEnabled(true);
		}
	}
	
	//Se o botão for clicado, abre-se a opção de escolher a cor do circulo
	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(this, "Escolha uma cor para o LED", Color.RED);
		if(color != null) {
			ledColor = color;
		if(output.isOn() == false){
			ledColor = Color.WHITE;			
			}
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
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(ledColor);
		Ellipse2D.Double circle = new Ellipse2D.Double(515, 155, 50, 50);
		g2d.fill(circle);
		
		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
	}
}