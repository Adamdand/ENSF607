/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: Yunying Zhang, Adam D'Andrea
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     */
    
    private void readObjectsFromFile(String name) 
    {
        MusicRecord record ;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several records.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
        	
            while ( true )
            {
            	record = (MusicRecord)input.readObject();

            	System.out.println("\nYear: " + record.getYear() + "\nSong Name: " + record.getSongName() 
                + "\nSinger Name: " + record.getSingerName() + "\nPurchase Price: " + record.getPurchasePrice());

            } 
            // END OF WHILE
        }
        
        catch(EOFException e)
        {
        	System.out.println("EOF reached");
        }
        
    catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	} 
       
    }           // END OF METHOD 
    
    
    public static void main(String [] args) 
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("allSongs.ser");
    }
}