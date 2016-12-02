package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfStamper;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;


public class ITextMergeThree {

public void merge3(String file3,String file4,String file5,String empCode,String payMonth,String AY,String Pan, int Cnt) {
	
    	List<InputStream> list3 = new ArrayList<InputStream>();
        try {
            // Source pdfs
        	
        	String x = "A" + (Cnt%4) ;
        	String y = "A" + ((Cnt+1)%4) ;
        	
        	list3.add(new FileInputStream(new File("c:/Newpdf16/Form-16"+x+".pdf")));
        	list3.add(new FileInputStream(new File("c:/report16/Part-A/"+payMonth+"/"+file3)));
            list3.add(new FileInputStream(new File("c:/report16/Part-B(anx)/"+payMonth+"/"+file4)));
            list3.add(new FileInputStream(new File("c:/report16/12BA/"+payMonth+"/"+file5)));

            // Resulting pdf
            //OutputStream out = new FileOutputStream(new File("c:/pdf16/"+payMonth+"/Form-16_"+empCode+".pdf"));
            
            
        //    OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));

            OutputStream out = new FileOutputStream(new File("c:/Newpdf16/Form-16"+y+".pdf"));
        		
            
            System.out.println("Employee Code-"+empCode);
            doMerge3(list3, out);
    
  
 
            
            
            
            
  //          Process pp = Runtime.getRuntime().exec("DEL c:/Newpdf16/Form-16.pdf") ;
    //        Process pp1 = Runtime.getRuntime().exec("REN c:/Newpdf16/Form-16a.pdf c:/Newpdf16/Form-16.pdf") ;
            System.out.println("Files Meerged");
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       public void doMerge3(List<InputStream> list3, OutputStream outputStream)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        
        for (InputStream in : list3) {
            PdfReader reader = new PdfReader(in);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }
        
        outputStream.flush();
        document.close();
        outputStream.close();
        
        
      /* String[] command =  new String[4];
        command[0] = "cmd";
        command[1] = "/C";
        command[2] = "DEL";
        command[3] ="c:\\Newpdf16\\Form-16.pdf" ;
        Process process = Runtime.getRuntime ().exec (command);
        
    //    String[] command2 =  new String[4];
      //  command2[0] = "cmd";
       // command2[1] = "/C";
        //command2[2] = "DEL";
        //command2[3] ="c:\\Newpdf16\\Form-16x.pdf" ;
        //Process process2 = Runtime.getRuntime ().exec (command2);
        
        String[] command1 =  new String[5];
        command1[0] = "cmd";
        command1[1] = "/C";
        command1[2] ="RENAME" ;
        command1[3] ="c:\\Newpdf16\\Form-16a.pdf" ;
        command1[4] ="c:\\Newpdf16\\Form-16.pdf" ;*/
        
/*  Process process1= Runtime.getRuntime ().exec (command1);*/
        
        
        
        
 /*       List<InputStream> listapp1 = new ArrayList<InputStream>();
        try {
            // Source pdfs
            //list.add(new FileInputStream(new File("C:/report/Part-A/"+AY+"/"+file3)));
      	  listapp1.add(new FileInputStream(new File("c:/Newpdf16/Form-16a.pdf")));
      	  //list1.add(new FileInputStream(new File("C:/report16/Part-B(anx)/"+payMonth+"/"+file4)));
            //list.add(new FileInputStream(new File("C:/report/12BA/"+payMonth+"/"+file5)));

            // Resulting pdf
           // OutputStream out = new FileOutputStream(new File("c:/pdf16/"+payMonth+"/Form-16_"+empCode+".pdf"));
            //OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));
            OutputStream out = new FileOutputStream(new File("c:/Newpdf16/Form-16.pdf"));
            //System.out.println("Employee Code-"+empCode);
            doMerge1(listapp1, out);
            System.out.println("Files Meerged");
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
        
        
        
        
        
        
        
    }
    
       
       
       
       
       
       
       
       
       
       
       
       
       
       public void merge21(String file3,String file4,String empCode,String payMonth,String AY,String Pan, int Cnt) {
    		
       	List<InputStream> list21 = new ArrayList<InputStream>();
           try {
               // Source pdfs
           	String x = "A" + (Cnt%4) ;
           	String y = "A" + ((Cnt+1)%4) ;
           	
           		list21.add(new FileInputStream(new File("c:/Newpdf16/Form-16"+x+".pdf")));
        	   
        	   //list21.add(new FileInputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16.pdf")));
        	   list21.add(new FileInputStream(new File("C:/report16/Part-A/"+payMonth+"/"+file3)));
               list21.add(new FileInputStream(new File("C:/report16/Part-B(anx)/"+payMonth+"/"+file4)));
               //list.add(new FileInputStream(new File("C:/report/12BA/"+payMonth+"/"+file5)));

               // Resulting pdf
               //OutputStream out = new FileOutputStream(new File("c:/pdf16/"+payMonth+"/Form-16_"+empCode+".pdf"));
           //    OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));
               //    OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));

               OutputStream out = new FileOutputStream(new File("c:/Newpdf16/Form-16"+y+".pdf"));
               System.out.println("Employee Code-"+empCode);
               doMerge21(list21, out);
               System.out.println("Files Meerged");
               

           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (DocumentException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

          public void doMerge21(List<InputStream> list21, OutputStream outputStream)
               throws DocumentException, IOException {
           Document document = new Document();
           PdfWriter writer = PdfWriter.getInstance(document, outputStream);
           document.open();
           PdfContentByte cb = writer.getDirectContent();
           
           for (InputStream in : list21) {
               PdfReader reader = new PdfReader(in);
               for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                   document.newPage();
                   //import the page from source pdf
                   PdfImportedPage page = writer.getImportedPage(reader, i);
                   //add the page to the destination pdf
                   cb.addTemplate(page, 0, 0);
               }
           }
           
           outputStream.flush();
           document.close();
           outputStream.close();
       }
          
          
          
          
          
          
          
          
          public void merge22(String file4,String file5,String empCode,String payMonth,String AY,String Pan, int Cnt) {
      		
             	List<InputStream> list22 = new ArrayList<InputStream>();
                 try {
                     // Source pdfs
                	 	String x = "A" + (Cnt%4) ;
                       	String y = "A" + ((Cnt+1)%4) ;
                       	
                       	list22.add(new FileInputStream(new File("c:/Newpdf16/Form-16"+x+".pdf")));
                    	   
                    	   //	 list22.add(new FileInputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16.pdf")));
                //	 list22.add(new FileInputStream(new File("C:/report16/Part-A/"+AY+"/"+file4)));
                	// c:\\report16\\Part-B(anx)\\"+payMonth+"\\PartB.pdf
                	 list22.add(new FileInputStream(new File("C:/report16/Part-B(anx)/"+payMonth+"/"+file4)));
                     list22.add(new FileInputStream(new File("C:/report16/12BA/"+payMonth+"/"+file5)));

                     // Resulting pdf
                    // OutputStream out = new FileOutputStream(new File("c:/pdf16/"+payMonth+"/Form-16_"+empCode+".pdf"));
                    // OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));
                     //    OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));

                     OutputStream out = new FileOutputStream(new File("c:/Newpdf16/Form-16"+y+".pdf"));
                     System.out.println("Employee Code-"+empCode);
                     doMerge22(list22, out);
                     System.out.println("Files Meerged");
                     

                 } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 } catch (DocumentException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }

                public void doMerge22(List<InputStream> list22, OutputStream outputStream)
                     throws DocumentException, IOException {
                 Document document = new Document();
                 PdfWriter writer = PdfWriter.getInstance(document, outputStream);
                 document.open();
                 PdfContentByte cb = writer.getDirectContent();
                 
                 for (InputStream in : list22) {
                     PdfReader reader = new PdfReader(in);
                     for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                         document.newPage();
                         //import the page from source pdf
                         PdfImportedPage page = writer.getImportedPage(reader, i);
                         //add the page to the destination pdf
                         cb.addTemplate(page, 0, 0);
                     }
                 }
                 
                 outputStream.flush();
                 document.close();
                 outputStream.close();
             }
                
                
          
          
          public void merge1(String file4,String empCode,String payMonth,String AY,String Pan, int Cnt) {
        		
          	List<InputStream> list1 = new ArrayList<InputStream>();
              try {
                  // Source pdfs
            	 	String x = "A" + (Cnt%4) ;
                   	String y = "A" + ((Cnt+1)%4) ;
                   	
                   	list1.add(new FileInputStream(new File("c:/Newpdf16/Form-16"+x+".pdf")));
                	   
                	   //list1.add(new FileInputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16.pdf")));
            	  list1.add(new FileInputStream(new File("C:/report16/Part-B(anx)/"+payMonth+"/"+file4)));
                  //list.add(new FileInputStream(new File("C:/report/12BA/"+payMonth+"/"+file5)));

                  // Resulting pdf
                 // OutputStream out = new FileOutputStream(new File("c:/pdf16/"+payMonth+"/Form-16_"+empCode+".pdf"));
                  //OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));
            	     //    OutputStream out = new FileOutputStream(new File("c:/Newpdf16/"+payMonth+"/Form-16_"+Pan+"_"+AY+".pdf"));

                  OutputStream out = new FileOutputStream(new File("c:/Newpdf16/Form-16"+y+".pdf"));
                  System.out.println("Employee Code-"+empCode);
                  doMerge1(list1, out);
                  System.out.println("Files Meerged");
                  

              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (DocumentException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }

             public void doMerge1(List<InputStream> list1, OutputStream outputStream)
                  throws DocumentException, IOException {
              Document document = new Document();
              PdfWriter writer = PdfWriter.getInstance(document, outputStream);
              document.open();
              PdfContentByte cb = writer.getDirectContent();
              
              for (InputStream in : list1) {
                  PdfReader reader = new PdfReader(in);
                  for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                      document.newPage();
                      //import the page from source pdf
                      PdfImportedPage page = writer.getImportedPage(reader, i);
                      //add the page to the destination pdf
                      cb.addTemplate(page, 0, 0);
                  }
              }
              
              outputStream.flush();
              document.close();
              outputStream.close();
          }
          
       
    
}