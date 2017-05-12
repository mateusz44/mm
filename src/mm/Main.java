package mm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	class ViewUnit{
		private JLabel jl;
		private JTextField jtf; 
		ViewUnit(String s1, String s2)
		{	 
			jl = new JLabel();
			jtf = new JTextField();
			jl.setText(s1);
			jtf.setBounds(0, 0, 20, 60); 
			jtf.setText(s2);

		}
		public JTextField getJText(){
			return jtf;
		}
		public JLabel getJLabel(){
			return jl;
		}
	}
	class Role{
		private JComboBox<String> jb;
		private Function function;
		Role(){
			jb = new JComboBox(new String[]{"a","b","c"});
			function = new Function(jb);
		}
		public Function getFunction(){
			return function;
		}
		public JComboBox getRoleCombo(){
			return jb;
		}
	}
	class Contact{
		private JPanel cp;
		private ViewUnit u;
		private Role r;
		Contact(String s1, String s2){
			cp = new JPanel(); 
			cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
			u = new ViewUnit(s1, s2);
			r = new Role();
			cp.add(u.getJLabel());
			cp.add(u.getJText());
			cp.add(r.getRoleCombo());
			cp.add(r.getFunction().getFunctionCombo());
		}
		public JPanel getJPanel(){
			return cp;
		}
	}
	class Function{
		private Map<String, List<String>> fmap;
		private List<String> ls;
		private JComboBox jbx;
		Function(JComboBox jcb){
			fmap = new HashMap<String, List<String>>();
			int i =0;
			while(i<jcb.getItemCount())
			{
				ls = new ArrayList<String>();
				ls.add((String)jcb.getItemAt(i)+i);
				fmap.put((String)jcb.getItemAt(i++), ls);
			}
			makeCombo();
		}
		public JComboBox makeCombo(){
			int i =0;
			jbx = new JComboBox();
			while(i<ls.size())
			{
				jbx.addItem(ls.get(i++));
			}
			return jbx;			
		}
		public JComboBox getFunctionCombo(){
			return jbx;
		}
	}
	class Component {
		JFrame f;
		Contact ct;
		Component() {
			f=new JFrame("LOG IN FORM");
		      Contact ct = new Contact("dd", "f");
              f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
              f.setSize(100, 200);
              f.setLayout(new FlowLayout());
              f.add(ct.getJPanel());
              f.setVisible(true);              
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		Component c = m.new Component(); 
	}
}
