package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;


// Esta classe representa a interface principal, que permite
// selecionar uma calculadora de densidade a partir de um menu.
public class MainView extends JPanel implements ActionListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	// A componente JComboBox representa um menu.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
	private JComboBox<Gate> comboBox;

	private GatesView gatesView;


	public MainView(List<Gate> model) {
		comboBox = new JComboBox<>();

		for(Gate gate: model) {
			comboBox.addItem(gate);
		}

		// Esta linha garante que, sempre que o usuario selecionar
		// um item do menu, o metodo actionPerformed abaixo sera chamado.
		// Voce usou a interface ActionListener no Projeto 1, lembra?
		comboBox.addActionListener(this);

		// Esta linha garante que os componentes sejam simplesmente
		// colocados em linha reta, mais especificamente na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(comboBox);

		// A descricao do metodo addCalculatorView esta logo abaixo.
		addGatesView(comboBox.getItemAt(0));
	}


	// Este metodo constroi uma nova interface para uma
	// calculadora e coloca essa interface abaixo do menu.
	private void addGatesView(Gate gate) {
		gatesView = new GatesView(gate);
		add(gatesView);
	}


	/* A PARTIR DESTE PONTO VOCE DEVE ENTENDER SOZINHO */


	@Override
	public void actionPerformed(ActionEvent event) {
		remove(gatesView);

		int index = comboBox.getSelectedIndex();
		Gate gate = comboBox.getItemAt(index);
		addGatesView(gate);

		// Necessario para atualizar a janela.
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		frame.pack();
	}
}
