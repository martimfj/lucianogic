package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;
import br.pro.hashi.ensino.desagil.lucianogic.model.Switch;



// Esta classe representa a interface de uma calculadora de densidade, com
// os dois campos de entrada (peso e raio) e o campo de saida (resultado).
public class GatesView extends JPanel implements ItemListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


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
		this.gate = gate;
		int size = gate.getSize();
		
		buttonA = new Switch();
		buttonB = new Switch();
		buttonC = new Switch();
		
		gate.connect(buttonA, 0);
		
		if(size == 2){
			gate.connect(buttonB, 1);
		}
		
		if(size == 3){
			gate.connect(buttonC, 2);
		}
		
		
		// A componente JLabel representa simplesmente um texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel inputLabel = new JLabel("Entradas:");
		JLabel outputLabel = new JLabel("Saída:");
		
		add(inputLabel);
		inputBoxA = new JCheckBox("A");
		inputBoxB = new JCheckBox("B");
		inputBoxC = new JCheckBox("Selector");
		
		inputBoxA.addItemListener(this);
		inputBoxB.addItemListener(this);
		inputBoxC.addItemListener(this);
		
		outputBox = new JCheckBox("Saída");
		outputBox.setEnabled(false);


		// Esta linha garante que os componentes sejam simplesmente
		// colocados em linha reta, mais especificamente na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/* A PARTIR DESTE PONTO VOCE DEVE ENTENDER SOZINHO */

		add(inputBoxA);
		add(inputBoxB);
		
		if(size == 2){
			add(inputBoxB);
		}
		else {
			remove(inputBoxB);
		}
		
		if(size == 3){
			add(inputBoxC);
		}
		else {
			remove(inputBoxC);
		}
		
		add(outputLabel);
		add(outputBox);
		
		if(gate.read() == false){
			outputBox.setSelected(false);
		}
		if(gate.read() == true){
			outputBox.setSelected(true);
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
			outputBox.setSelected(false);
		}
		
		if(gate.read() == true){
			outputBox.setSelected(true);
		}
	}

}