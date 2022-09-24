package javafinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Random;

public class javafinal implements ActionListener
{
     JFrame frame;
    Random randomGenerator;
    JButton kagitbutton;
    JButton tasbutton;
    JButton makasbutton;
    JButton resetButton;
    Font f;
    Border edge;
    Container contentPane;
    JTextArea outputArea;
    JTextArea scoreArea;
    JPanel buttonPanel;
    int k_secim;
    int pc_secim;
    int k_wins;
    int pc_wins;
    public static final int tas = 0;
    public static final int kagit = 1;
    public static final int makas = 2;
    
    
    public javafinal()
    {
    	
    	k_secim = 0;
    	pc_secim = 0;
    	k_wins = 0;
    	pc_wins = 0;
    
        frame = new JFrame ( " TAŞ KAĞIT MAKAS " );       
        Toolkit kit = frame.getToolkit();
        Dimension size = kit.getScreenSize();
        frame.setBounds ( size.width/4, size.height/4, size.width/2, size.height/2 );
        frame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        
        randomGenerator = new Random ();
        f = new Font( "Comic Sans MS", Font.BOLD, 20);       
        frame.setVisible ( true );
        
        edge = BorderFactory.createRaisedBevelBorder();
        contentPane = frame.getContentPane();
       
        
        outputArea = new JTextArea ( 20, 40 );
        outputArea.setEditable( false );
        outputArea.setFont( f );
        
        scoreArea = new JTextArea( 1, 40 );
        scoreArea.setEditable( false );
        scoreArea.setFont( f );
        
        kagitbutton = new JButton (  );
        Image k_img=new ImageIcon(javafinal.class.getResource("/kagit.png")).getImage();
        kagitbutton.setIcon(new ImageIcon(k_img));        
        kagitbutton. setBorder ( edge );  
        kagitbutton.addActionListener( this );
        
        tasbutton = new JButton ( );
        Image t_img=new ImageIcon(javafinal.class.getResource("/tas.png")).getImage();
        tasbutton.setIcon(new ImageIcon(t_img)); 
        tasbutton. setBorder ( edge );        
        tasbutton.addActionListener( this );
        
        
        makasbutton = new JButton ();
        Image m_img=new ImageIcon(javafinal.class.getResource("/makas.png")).getImage();    
        makasbutton.setIcon(new ImageIcon(m_img));      
        makasbutton. setBorder ( edge );
        makasbutton.addActionListener( this );
        
        resetButton = new JButton ( "SIFIRLA" );
        resetButton.addActionListener( this );
        
        buttonPanel = new JPanel();       
        buttonPanel.add ( tasbutton );
        buttonPanel.add ( kagitbutton );       
        buttonPanel.add ( makasbutton );
        buttonPanel.add(resetButton, BorderLayout.PAGE_START);
        
        contentPane.add( buttonPanel, BorderLayout.NORTH );
        contentPane.add( outputArea, BorderLayout.CENTER );
        contentPane.add( scoreArea, BorderLayout.SOUTH );
        buttonPanel.setBackground(Color.pink);
        outputArea.setBackground(Color.pink);
        scoreArea.setBackground(Color.pink);
        
        
        
    }
    
    public void actionPerformed( ActionEvent e )
    {
     if( e.getSource() == tasbutton ){
    	 k_secim = tas; 	 
         playGame();
         
        }
     if(e.getSource() == makasbutton  )   {
    	 k_secim = makas;
         playGame();
        }
     if( e.getSource() == kagitbutton ) {
    	 k_secim = kagit;
         playGame();
        }
     if( e.getSource() == resetButton ) {
         reset();
        }
    }
    
    public void reset()
    {
    	k_wins = 0;
    	pc_wins = 0;
        outputArea.setText("");
        scoreArea.setText("");
    }
    
    public void playGame()
    {
    	pc_secim = randomGenerator.nextInt( 3 );
        
        
        switch( k_secim) {
            case tas:
            if( pc_secim == kagit ) {
            	
                outputArea.setText("Bilgisayar Kağıdı Seçti, Siz Taşı Seçtiniz\\n\\n"); 
                outputArea.append( "Bilgisayar Kazandı!" );
                pc_wins = pc_wins + 1;
            }
            if( pc_secim == makas ) {
                outputArea.setText("Bilgisayar Makası Seçti, Siz Taşı Seçtiniz\n\n"); 
                outputArea.append( "Siz Kazandınız!" );
                k_wins = k_wins + 1;
            }
            else{
                outputArea.setText( "Bilgisayar Taşı Seçti, Sizde Taşı Seçtiniz\n\n" );
                outputArea.append( "Berabere Kaldınız" );
            }
            break;
            case kagit:
            if( pc_secim == tas ){
            	
                outputArea.setText("Bilgisayar Taşı Seçti ve Siz Kağıdı Seçtiniz\n\n"); 
                outputArea.append( "Siz Kazandınız!" );
                k_wins = k_wins + 1;
            }
            if( pc_secim == makas ) {
                outputArea.setText("Bilgisayar Makası Seçti ve Siz Kağıdı Seçtiniz\n\n"); 
                outputArea.append( "Bilgisayar Kazandı!" );
                pc_wins = pc_wins + 1;
            }
            else{
                outputArea.setText( "Bilgisayar Kağıdı Seçti ve Sizde Kağıdı Seçtiniz\n\n" );
                outputArea.append( "Berabere Kaldınız!" );
            }
            break;
            case makas:
            if( pc_secim == tas ){
                outputArea.setText("Bilgisayar Taşı Seçti ve Siz Makası Seçtiniz\n\n"); 
                outputArea.append( "Bilgisayar Kazandı!" );
                pc_wins = pc_wins + 1;
            }
            if( pc_secim == kagit ) {
                outputArea.setText("Bilgisayar Kağıdı Seçti ve Siz Makası Seçtiniz\n\n"); 
                outputArea.append( "Siz Kazandınız!" );
                k_wins = k_wins + 1;
            }
            else{
                outputArea.setText( "Bilgisayar Makası Seçti ve Sizde Makası Seçtiniz\n\n" );
                outputArea.append( "Berabere Kaldınız!" );
            }
            break;
        }
            
        scoreArea.setText( "SCORE: SİZ= " + k_wins + "   BİLGİSAYAR= " + pc_wins );
    }
    
    public static void main(String [] args)
    {
    	javafinal game = new javafinal();
    	
    	
    }
    
    
    
    
    
    
}