import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class btm12c4 extends JFrame implements ActionListener 
, MouseListener {
Vector vData = new Vector();
Vector vTitle = new Vector();
JScrollPane tableResuilt;
DefaultTableModel model;
JTable tb = new JTable();
JButton delete;
int selectedrow = 0;
String [] columns = {"ID", "NAME", "Math", "Physical", "Chem", "Aver"
};
String [][] Data = {{
    "1", "hcphap","8","9","7","8"} ,
    {"2","ddtho","9","9","9","9"},
    {"3","nvhung","8","9","10","9"},
    {"4","hhtung","8.5","9","9.5","9"},};
public btm12c4 (String s){
    super(s);
    try{
        JPanel p = new JPanel();
        delete = new JButton("Delete");
        delete.addActionListener(this);
        p.add(delete);
        this.add(p,"South");
        load();
        model = new DefaultTableModel(vData , vTitle);
        tb = new JTable(model);
        tb.addMouseListener(this);

        tableResuilt = new JScrollPane(tb);
        this.getContentPane().add(tableResuilt,"North");
        this.setSize(400,300);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
}
public void load(){
    try{
     vTitle.clear(); 
     vData.clear();
     int num_column   = columns.length;
     for(int i =0 ; i<num_column ; i++){
        vTitle.add(columns[i]);
     }
     for(int i =0 ; i<Data.length ; i++){
        Vector row = new Vector(num_column);
        for(int j =0 ; j<num_column ; j++)
            row.add(Data[i][j]);
            vData.add(row);
        

}
    }
    catch(Exception e){
        System.out.println(e.getMessage());
}
}
public void delete(){
    try{
        Vector st = (Vector)vData.elementAt(selectedrow);
        vData.removeElementAt(selectedrow);
        model.fireTableDataChanged();
        }
        catch(Exception e){
           e.printStackTrace();
    }
}
public void actionPerformed(ActionEvent e ){
    if(e.getActionCommand().equals("Delete")){
        delete();
    }
    }
    public void mouseClicked(MouseEvent e){
        selectedrow = tb.getSelectedRow();
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
    }

public static void main(String[] args) {
    
    new btm12c4("view Students");
}
}