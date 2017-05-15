package mm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	class ViewUnit {
		private JLabel jl;
		private JTextField jtf;

		ViewUnit(String s1, String s2) {
			jl = new JLabel();
			jtf = new JTextField();
			jl.setText(s1);
			jtf.setBounds(0, 0, 20, 60);
			jtf.setText(s2);

		}

		public JTextField getJText() {
			return jtf;
		}

		public JLabel getJLabel() {
			return jl;
		}
	}

	class Role {
		private JComboBox<String> jb;
		private JLabel jl;
		private Task function;
		private Map<String, String[]> tasks;
		private List<String> ls = new ArrayList<String>();

		Role() {
			jl = new JLabel("role");
			jb = new JComboBox(new String[] { "a", "b", "c" });
			tasks = new HashMap<String, String[]>();
			String[][] els = { { "e", "e", "e" }, { "e", "e", "d" },
					{ "e", "d", "d" } };
			int i = 0;
			while (i < jb.getItemCount())
				tasks.put(jb.getItemAt(i), els[i++]);
			function = new Task(jb.getItemAt(0), els[0]);

			ActionListener actList = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String s = (String) jb.getSelectedItem();// get the selected

				}

			};
			jb.addActionListener(actList);
		}

		public Task getTask() {
			return function;
		}

		public JComboBox getRoleCombo() {
			return jb;
		}

		public JLabel getJLabel() {
			return jl;
		}
	}

	class Contact {
		private JPanel cp;
		private JButton jb;
		private ViewUnit u;
		private Role r;

		Contact(String s1, String s2) {
			cp = new JPanel();
			cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
			u = new ViewUnit("ss", "s");
			r = new Role();
			cp.add(u.getJLabel());
			KeyListener l = new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {

				}

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

					int keyCode = e.getKeyCode();
					String keyText = KeyEvent.getKeyText(keyCode);
					System.out
							.println(" : " + keyText + " / " + e.getKeyChar());

				}
			};
			MouseListener ml = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					System.out.println(" : ");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			};
			((JTextField) u.getJText()).addKeyListener(l);
			cp.add(u.getJText());
			cp.add(r.getJLabel());
			cp.add(r.getRoleCombo());
			cp.add(r.getJLabel());
			int i = 0;
			cp.add(r.getTask().getJPanel());
			jb = new JButton("ok");
			jb.addKeyListener(l);
			jb.addMouseListener(ml);
			cp.add(jb);
		}

		public JPanel getJPanel() {
			return cp;
		}
	}

	class Task {
		private List<String> ls;
		private JLabel jl;
		private JPanel jp;
		private JCheckBox[] jcbarray = { new JCheckBox("a1"),
				new JCheckBox("b1"), new JCheckBox("c1") };

		public Task(String str, String[]list) {
			jp = new JPanel();
			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
			jl = new JLabel(str);
			int i = 0;
			while (i < list.length) {
				if (list[i].equals("e"))
					jcbarray[i].setSelected(true);
				else
					jcbarray[i].setSelected(false);
				jp.add(jcbarray[i]);
				i++;
			}
		}

		public void setJCB(String[] list) {

		}

		public JPanel getJPanel(){
			return jp;
		}
	}

	class Component {
		JFrame f;
		Contact ct;

		Component() {
			f = new JFrame("LOG IN FORM");
			Contact ct = new Contact("dd", "f");
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setSize(100, 200);
			f.setLayout(new FlowLayout());
			f.add(ct.getJPanel());
			f.setVisible(true);
		}
	}

	interface BCRT {
		class Text {
			String str = "new contact new role new task";

			public String getText() {
				return str;
			}
		}
	}

	interface BCT extends BCRT {
		class Text {
			String str = "new contact new task";

			public String getText() {
				return str;
			}
		}
	}

	interface BCR extends BCRT {
		class Text {
			String str = "new contact new role";

			public String getText() {
				return str;
			}
		}
	}

	interface BTR extends BCRT {
		class Text {
			String str = "new role new task";

			public String getText() {
				return str;
			}
		}
	}

	interface BC extends BCR, BCT {
		class Text {
			String str = "new contact";

			public String getText() {
				return str;
			}
		}
	}

	interface BR extends BCR, BTR {
		class Text {
			String str = "new role";

			public String getText() {
				return str;
			}
		}
	}

	interface BT extends BTR, BCT {
		class Text {
			String str = "new task";

			public String getText() {
				return str;
			}
		}
	}

	class B implements BC, BR, BT {
		class Text {
			String str = "ok";

			public String getText() {
				return str;
			}
		}
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		Component c = m.new Component();
	}
}
