package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;
import br.pro.hashi.ensino.desagil.lucianogic.view.MainView;


// Esta classe representa a interface de uma calculadora de densidade, com
// os dois campos de entrada (peso e raio) e o campo de saida (resultado).
public class GatesView extends JPanel implements KeyListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	// A componente JTextField representa um campo para digitacao de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	private	JCheckBox inputBoxA;
	private	JCheckBox inputBoxB;
	private	JCheckBox inputBoxC;
	private	JCheckBox outputBox;
	
	private Gate gate;


	public GatesView(Gate gate) {
		this.gate = gate;
		int size = gate.getSize();

		// A componente JLabel representa simplesmente um texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel inputLabel = new JLabel("Entradas:");
		JLabel outputLabel = new JLabel("Saída:");
		
		add(inputLabel);
		inputBoxA = new JCheckBox("A");
		inputBoxB = new JCheckBox("B");
		inputBoxC = new JCheckBox("Selector");
		
		outputBox = new JCheckBox();
		outputBox.setSelected(true);
		outputBox.setEnabled(false);


		// Esta linha garante que os componentes sejam simplesmente
		// colocados em linha reta, mais especificamente na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/* A PARTIR DESTE PONTO VOCE DEVE ENTENDER SOZINHO */

		add(inputBoxA);
		add(inputBoxB);
		if(size == 3){
			add(inputBoxC);
		}
		else {
			remove(inputBoxC);
		}
		add(outputLabel);
		add(outputBox);
		
//		int outcome = (gate.read()) ? 1 : 0;  (Converte booleana pra int)
//		outputBox.setText(""+outcome); 		  (Seta o texto da outputBox)
		outputBox.setText("Output");
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}