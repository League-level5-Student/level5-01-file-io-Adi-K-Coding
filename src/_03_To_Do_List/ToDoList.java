package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton("Add Task");
	JButton viewTask = new JButton("View Tasks");
	JButton removeTask = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.run();
		tdl.loadListMethod();
	}

	void run() {
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.addActionListener(e -> {
			String input = JOptionPane.showInputDialog("Enter your task");
			tasks.add(input);
		});
		viewTask.addActionListener(e -> {
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println(tasks.get(i));
			}
		});
		removeTask.addActionListener(e -> {
			for (int i = 0; i < tasks.size(); i++) {
				String remove = JOptionPane.showInputDialog("Enter the task you want to remove");
				if (remove == tasks.get(i)) {
					tasks.remove(i);
				}
			}
		});
		saveList.addActionListener(e -> {
			try {
				FileWriter fw = new FileWriter("src/test3.txt");
				for (int i = 0; i < tasks.size(); i++) {
					fw.write(tasks.get(i) + "\n");
				}

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		loadList.addActionListener(e -> {
			loadListMethod();
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	void loadListMethod() {
		tasks.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/test3.txt"));

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
				tasks.add(line);
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
