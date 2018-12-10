import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.*;


public class FileZipper extends JFrame
{
    public FileZipper()
    {
        this.setTitle("Zipper");
        this.setBounds(275, 300, 250, 250);
        this.setJMenuBar(menuBar);
        
        JMenu menuPlik = menuBar.add(new JMenu("File"));
             
        Action addAction = new Akcja("Add", "Add new item", "ctrl D", new ImageIcon("dodaj.png"));
        Action removeAction = new Akcja("Remove„", "Remove", "ctrl U", new ImageIcon("usun.png"));
        Action zipAction = new Akcja("Zip", "Zipuj", "ctrl Z");
        
        JMenuItem menuOpen = menuPlik.add(addAction);
        JMenuItem menuRemove = menuPlik.add(removeAction);
        JMenuItem menuZip = menuPlik.add(zipAction);
        
        bAdd = new JButton(addAction);
        bRemove = new JButton(removeAction);
        bZip = new JButton(zipAction);
        JScrollPane scrollek = new JScrollPane(lista);
        
        lista.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout layout = new GroupLayout(this.getContentPane());
        
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(scrollek, 100, 150, Short.MAX_VALUE)
                .addContainerGap(0, Short.MAX_VALUE)
                .addGroup(
                layout.createParallelGroup().addComponent(bAdd).addComponent(bRemove).addComponent(bZip)
                
                )
                );
        
        layout.setVerticalGroup(
                layout.createParallelGroup()
                .addComponent(scrollek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup().addComponent(bAdd).addComponent(bRemove).addGap(5, 40, Short.MAX_VALUE).addComponent(bZip))
                );
        
        this.getContentPane().setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack();
    }
    private DefaultListModel listModel = new DefaultListModel()
    {
        @Override
        public void addElement(Object obj) 
        {
            lista.add(obj);
            super.addElement(((File)obj).getName());
        }
        @Override
        public Object get(int index) 
        {
            return lista.get(index);
        }
           
        @Override
        public Object remove(int index) 
        {
            lista.remove(index);
            return super.remove(index);
        }        
        ArrayList lista = new ArrayList();
    };
    private JList lista = new JList(listModel);
    private JButton bAdd;
    private JButton bRemove;
    private JButton bZip;
    private JMenuBar menuBar = new JMenuBar();
    private JFileChooser choice = new JFileChooser();
    public static void main(String[] args)
    {
        new FileZipper().setVisible(true);
    }
    
    private class Akcja extends AbstractAction
    {
        public Akcja(String name, String descript, String keybKey)
        {
            this.putValue(Action.NAME, name);
            this.putValue(Action.SHORT_DESCRIPTION, descript);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(keybKey));
        }
        public Akcja(String name, String descript, String keybKey, Icon ikona)
        {
            this(name, descript ,keybKey);
            this.putValue(Action.SMALL_ICON, ikona);
        }

        public void actionPerformed(ActionEvent e) 
        {
           if (e.getActionCommand().equals("Add"))
               addItem();
           else if (e.getActionCommand().equals("Remove„"))
               removeItem();
           else if (e.getActionCommand().equals("Zip"))
               createZipArchive();
        }
        
        private void addItem()
        {
            choice.setCurrentDirectory(new File(System.getProperty("user.dir")));
            choice.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            choice.setMultiSelectionEnabled(true);
            
            int tmp = choice.showDialog(rootPane, "Add to archive");
            
            if (tmp == JFileChooser.APPROVE_OPTION)
            {
                File[] sciezki = choice.getSelectedFiles();
                
                for (int i = 0; i < sciezki.length; i++)
                  if(!repeatItem(sciezki[i].getPath()))
                    listModel.addElement(sciezki[i]);
                
            }
        }
        private boolean repeatItem(String testItem)
        {
            for (int i = 0; i < listModel.getSize(); i++)
                if (((File)listModel.get(i)).getPath().equals(testItem))
                    return true;
            
            return false;
        }
        private void removeItem()
        {
            int[] tmp = lista.getSelectedIndices();
            
            for (int i = 0; i < tmp.length; i++)
                listModel.remove(tmp[i]-i);
        }
        
        private void createZipArchive()
        {
            choice.setCurrentDirectory(new File(System.getProperty("user.dir")));
            choice.setSelectedFile(new File(System.getProperty("user.dir")+File.separator+"mynameofzip.zip"));
            int tmp = choice.showDialog(rootPane, "Compress");
            
            if (tmp == JFileChooser.APPROVE_OPTION)
            {
               byte tmpData[] = new byte[BUFFOR];
               try
               {
                ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(choice.getSelectedFile()),BUFFOR));

                for (int i = 0; i < listModel.getSize(); i++)
                {
                    if (!((File)listModel.get(i)).isDirectory())
                        zipuj(zOutS, (File)listModel.get(i), tmpData, ((File)listModel.get(i)).getPath());
                    else
                    {
                        writeTrack((File)listModel.get(i));
                                
                        for (int j = 0; j < trackList.size(); j++)
                          zipuj(zOutS, (File)trackList.get(j), tmpData, ((File)listModel.get(i)).getPath());
                        
                        trackList.removeAll(trackList);
                    }
                        
                }

                zOutS.close();
               }
               catch(IOException e)
               {
                   System.out.println(e.getMessage());
               }
            }
        }
        private void zipuj(ZipOutputStream zOutS, File fileTrack, byte[] tmpData, String baseTrack) throws IOException
        {
            BufferedInputStream inS = new BufferedInputStream(new FileInputStream(fileTrack), BUFFOR);

            zOutS.putNextEntry(new ZipEntry(fileTrack.getPath().substring(baseTrack.lastIndexOf(File.separator)+1)));
            
            int counter;
            while ((counter = inS.read(tmpData, 0, BUFFOR)) != -1)
                zOutS.write(tmpData, 0, counter);


            zOutS.closeEntry();

            inS.close();            
        }
        public static final int BUFFOR = 1024;
       
        private void writeTrack(File trackName)
        {
           String[] nameFileAndFolder = trackName.list();

           for (int i = 0; i < nameFileAndFolder.length; i++)
           {
               File p = new File(trackName.getPath(), nameFileAndFolder[i]);

               if (p.isFile())
                   trackList.add(p);

               if (p.isDirectory())
                   writeTrack(new File(p.getPath()));

           }
        }
        
        ArrayList trackList = new ArrayList();
    }
    
}
