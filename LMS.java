import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;


class reservoir
{
	String name,issue_date,rollNo;
	int type,resourceIndex,bookIndex;
	
}


class myPair
{
	int uid;
	Boolean reserved;
	myPair()
	{

	}

	myPair(int val)
	{
		uid=val;
		reserved=true;
	}
}

class Resource
{
	String title,author,catagory;
	int ind;
	ArrayList<myPair> bookList=new ArrayList<myPair>();
	int avail;

	public int getIndex()
	{
		int i;
		for(i=0;i<bookList.size();i++)
		{
			if(bookList.get(i).reserved==true)
				break;
		}
		return i;
	}
}

class Book extends Resource
{
	Book(String t,String a,String c)
	{
		ind=0;
		title=t;
		author=a;
		catagory=c;
		avail=1;
		myPair mp=new myPair(LMS.bookId);
		bookList.add(mp);
		LMS.bookId++;
	}

	public void Update()
	{
		avail+=1;
		myPair mp=new myPair(LMS.bookId);
		bookList.add(mp);
		LMS.bookId++;
	}

	public void reserve(int ind)
	{
		bookList.get(ind).reserved=false;
		avail--;
	}

	public void release(int ind)
	{
		bookList.get(ind).reserved=true;
		avail++;
	}
}

class EBook extends Resource
{
	EBook(String t,String a,String c)
	{
		ind=0;
		title=t;
		author=a;
		catagory=c;
		avail=1;
		myPair mp=new myPair(LMS.bookId);
		bookList.add(mp);
		LMS.bookId++;
	}

	public void Update()
	{
		avail+=1;
		myPair mp=new myPair(LMS.bookId);
		bookList.add(mp);
		LMS.bookId++;
	}

	public void reserve(int ind)
	{
		bookList.get(ind).reserved=false;
		avail--;
	}

	public void release(int ind)
	{
		bookList.get(ind).reserved=true;
		avail++;
	}
}

class ePriodical extends Resource
{
	ePriodical(String t,String a,String c)
	{
		ind=0;
		title=t;
		author=a;
		catagory=c;
		avail=1;
		myPair mp=new myPair(LMS.bookId);
		bookList.add(mp);
		LMS.bookId++;
	}

	public void Update()
	{
		avail+=1;
		myPair mp=new myPair(LMS.bookId);
		bookList.add(mp);
		LMS.bookId++;
	}

	public void reserve(int ind)
	{
		bookList.get(ind).reserved=false;
		avail--;
	}

	public void release(int ind)
	{
		bookList.get(ind).reserved=true;
		avail++;
	}
}



public class LMS
{
	static int bookId;
	ArrayList<reservoir> reservedList=new ArrayList<reservoir>();
	ArrayList<ePriodical> eprio=new ArrayList<ePriodical>();
	ArrayList<EBook> ebooks=new ArrayList<EBook>();
	ArrayList<Book> books=new ArrayList<Book>();
	String username="admin";
	String password="passwd";
	public static void main(String[] args)
	{
		bookId=1;
		LMS obj=new LMS();
		Scanner sc=new Scanner(System.in);
		int choice,ch;
		while(true)
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("Welcome To Library Management System");
			System.out.println("1. Admin \t 2.Guest \t 3.Exit");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					obj.viewAdmin(obj);
					break;
				case 2:
					obj.viewGuest(obj);
					break;

				case 3:
					System.exit(0);
			}
		}
	}

	public void viewGuest(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		int choice;
		Boolean exit=false;
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("Welcome to Guest Panel!");
		while(true)
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("1.View Book");
			System.out.println("2.View E-Book");
			System.out.println("3.View Periodical");
			System.out.println("4.Search by Name");
			System.out.println("5.Search by Author Name");
			System.out.println("6.Exit");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
				case 1:
					lmsobj.viewBook();
					break;
				case 2:
					lmsobj.viewEBook();
					break;
				case 3:
					lmsobj.viewPeriodical();
					break;
				case 4:
					lmsobj.searchByName(lmsobj);
					break;
				case 5:
					lmsobj.searchByAuthor(lmsobj);
					break;
				case 6:
					exit=true;
					break;
			}
			if(exit)
				break;
		}
	}

	public void viewAdmin(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		int choice;
		Boolean exit=false;
		Console cnsl=null;
		String uname=null;
		cnsl=System.console();
		uname=cnsl.readLine("Enter username:");
		char [] pw=cnsl.readPassword("Enter Password:");
		String pwd=new String(pw);
		if(uname.equals(username))
		{
			if(password.equals(pwd))
			{
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("Welcome to Admin Panel!");
				while(true)
				{
					System.out.print("\033[H\033[2J");
					System.out.flush();
					System.out.println("1.Add Book");
					System.out.println("2.Add E-Book");
					System.out.println("3.Add Periodical");
					System.out.println("4.Update Book");
					System.out.println("5.Update E-Book");
					System.out.println("6.Update Periodical");
					System.out.println("7.View Book");
					System.out.println("8.View E-Book");
					System.out.println("9.View Periodical");
					System.out.println("10.Search by Name");
					System.out.println("11.Search by Author Name");
					System.out.println("12.Reserve Book");
					System.out.println("13.Release Book");
					System.out.println("14.View Reserved List");
					System.out.println("15.Logout");
					choice=sc.nextInt();
					switch(choice)
					{
						case 1:
							lmsobj.addBook(lmsobj);
							break;
						case 2:
							lmsobj.addEBook(lmsobj);
							break;
						case 3:
							lmsobj.addPeriodical(lmsobj);
							break;
						case 4:
							lmsobj.updateBook(lmsobj);
							break;
						case 5:
							lmsobj.updateEBook(lmsobj);
							break;
						case 6:
							lmsobj.updatePeriodical(lmsobj);
							break;
						case 7:
							System.out.print("\033[H\033[2J");
							System.out.flush();
							lmsobj.viewBook();
							break;
						case 8:
							System.out.print("\033[H\033[2J");
							System.out.flush();
							lmsobj.viewEBook();
							break;
						case 9:
							System.out.print("\033[H\033[2J");
							System.out.flush();
							lmsobj.viewPeriodical();
							break;
						case 10:
							lmsobj.searchByName(lmsobj);
							break;
						case 11:
							lmsobj.searchByAuthor(lmsobj);
							break;
						case 12:
							lmsobj.reserveBook(lmsobj);
							break;
						case 13:
							lmsobj.releaseBook(lmsobj);
							break;
						case 14:
							System.out.print("\033[H\033[2J");
							System.out.flush();
							lmsobj.viewReserve();
							break;
						case 15:
							exit=true;
							break;
					}
					if(exit)
						break;
				}
			}
			else
			{
				System.out.println("Sorry,wrong password!");
				sc.nextLine();
			}
		}
		else
		{
			System.out.println("Sorry,wrong username.");
			sc.nextLine();
		}
	}

	public void reserveBook(LMS lmsobj)
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
		Scanner sc=new Scanner(System.in);
		reservoir ob=new reservoir();
		System.out.println("Enter the name of the Student:");
		ob.name=sc.nextLine();
		System.out.println("Enter the Roll No:");
		ob.rollNo=sc.nextLine();
		ob.issue_date=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		System.out.println("1.Book \t 2.Periodical");
		System.out.println("Enter the type of book you want to reserve:");
		int ch,i,count,rid,bid;
		ch=sc.nextInt();
		sc.nextLine();
		count=0;

		if(ch==1)
		{
			System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("Copy"));
			System.out.println();
			for(i=0;i<books.size();i++)
			{
				if(books.get(i).avail>0)
				{
					System.out.format("%10d%30s%30s%30s%30d",i+1,books.get(i).title,books.get(i).author,books.get(i).catagory,books.get(i).avail);
					System.out.println();
					count++;
				}
			}
			if(count==0)
			{
				System.out.println("Sorry no books are available at this point of time");
				return;
			}
			System.out.println("Enter the Serial no:");
			rid=sc.nextInt();
			rid-=1;
			sc.nextLine();
			bid=books.get(rid).getIndex();
			books.get(rid).reserve(bid);
			ob.resourceIndex=rid;
			ob.type=1;
			ob.bookIndex=bid;
			reservedList.add(ob);
			System.out.println("Your book has been reserved!");
			sc.nextLine();
		}
		else if(ch==2)
		{
			System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("Copy"));
			System.out.println();
			for(i=0;i<eprio.size();i++)
			{
				if(eprio.get(i).avail>0)
				{
					System.out.format("%10d%30s%30s%30s%30d",i+1,eprio.get(i).title,eprio.get(i).author,eprio.get(i).catagory,eprio.get(i).avail);
					System.out.println();
					count++;
				}
			}
			if(count==0)
			{
				System.out.println("Sorry no books are available at this point of time");
				return;
			}
			System.out.println("Enter the Serial no:");
			rid=sc.nextInt();
			rid-=1;
			sc.nextLine();
			bid=eprio.get(rid).getIndex();
			eprio.get(rid).reserve(bid);
			ob.resourceIndex=rid;
			ob.type=2;
			ob.bookIndex=bid;
			reservedList.add(ob);
			System.out.println("Your book has been reserved!");
			System.out.println("Press any key to continue...");
			sc.nextLine();
		}
		else
		{
			System.out.println("Please enter valid choice");
			return;
		}

	}

	public void releaseBook(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		lmsobj.viewReserve();
		int i,choice,bid,rid;
		System.out.println("Enter the index you want to remove:");
		choice=sc.nextInt();
		if(choice>reservedList.size())
		{
			System.out.println("Sorry,Invalid choice!");
			return;
		}
		choice-=1;
		bid=reservedList.get(choice).bookIndex;
		rid=reservedList.get(choice).resourceIndex;
		if(reservedList.get(choice).type==1)
		{
			books.get(rid).release(bid);
		}
		else
		{
			eprio.get(rid).release(bid);
		}
		reservedList.remove(choice);
	}

	public void viewReserve()
	{
		Scanner sc=new Scanner(System.in);
		int i;
		System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Name"),new String("Roll No"),new String("Book Title"),new String("Issue Date"));
		System.out.println();
		for(i=0;i<reservedList.size();i++)
		{
			if(reservedList.get(i).type==1)
				System.out.format("%10s%30s%30s%30s%30s",i+1,reservedList.get(i).name,reservedList.get(i).rollNo,books.get(reservedList.get(i).bookIndex).title,reservedList.get(i).issue_date);
			else
				System.out.format("%10s%30s%30s%30s%30s",i+1,reservedList.get(i).name,reservedList.get(i).rollNo,eprio.get(reservedList.get(i).bookIndex).title,reservedList.get(i).issue_date);
			System.out.println();
		}
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void updateBook(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		lmsobj.viewBook();
		System.out.println("Enter the Serial No you want to update:");
		int choice;
		choice=sc.nextInt();
		if(choice>books.size())
		{
			System.out.println("Sorry,Please enter a valid choice!");
			return;
		}
		books.get(choice-1).Update();
		System.out.println("Your Book was updated successfully and ID is:"+(LMS.bookId-1));
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void updateEBook(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		lmsobj.viewEBook();
		System.out.println("Enter the Serial No you want to update:");
		int choice;
		choice=sc.nextInt();
		if(choice>ebooks.size())
		{
			System.out.println("Sorry,Please enter a valid choice!");
			return;
		}
		ebooks.get(choice-1).Update();
		System.out.println("Your Ebook was updated successfully and ID is:"+(LMS.bookId-1));
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void updatePeriodical(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		lmsobj.viewPeriodical();
		System.out.println("Enter the Serial No you want to update:");
		int choice;
		choice=sc.nextInt();
		if(choice>eprio.size())
		{
			System.out.println("Sorry,Please enter a valid choice!");
			return;
		}
		eprio.get(choice-1).Update();
		System.out.println("Your Periodical was updated successfully and ID is:"+(LMS.bookId-1));
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void viewBook()
	{
		Scanner sc=new Scanner(System.in);
		System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("ID"));
		System.out.println();
		int i,j,counter=1;
		for(i=0;i<books.size();i++)
		{
			for (j=0;j<books.get(i).bookList.size();j++)
			{
				System.out.format("%10d%30s%30s%30s%30d",counter,books.get(i).title,books.get(i).author,books.get(i).catagory,books.get(i).bookList.get(j).uid);
				System.out.println();
				counter++;
			}
		}
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void viewEBook()
	{
		Scanner sc=new Scanner(System.in);
		System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("ID"));
		System.out.println();
		int i,j,counter=1;
		for(i=0;i<ebooks.size();i++)
		{
			for(j=0;j<ebooks.get(i).bookList.size();j++)
			{
				System.out.format("%10d%30s%30s%30s%30d",counter,ebooks.get(i).title,ebooks.get(i).author,ebooks.get(i).catagory,ebooks.get(i).bookList.get(j).uid);
				System.out.println();
				counter++;
			}
		}
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void viewPeriodical()
	{
		Scanner sc=new Scanner(System.in);
		System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("ID"));
		System.out.println();
		int i,j,counter=1;
		for(i=0;i<eprio.size();i++)
		{
			for (j=0;j<eprio.get(i).bookList.size() ;j++ )
			{
				System.out.format("%10d%30s%30s%30s%30d",counter,eprio.get(i).title,eprio.get(i).author,eprio.get(i).catagory,eprio.get(i).bookList.get(j).uid);
				System.out.println();
				counter++;
			}
		}
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void addBook(LMS lmsobj)
	{
		String name,author,catagory;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Title:");
		name=sc.nextLine();
		System.out.println("Please Enter Author Name:");
		author=sc.nextLine();
		System.out.println("Please Enter catagory:");
		catagory=sc.nextLine();
		Book obj=new Book(name,author,catagory);
		books.add(obj);
		System.out.println("Your Book was added successfully and ID is:"+(LMS.bookId-1));
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void addEBook(LMS lmsobj)
	{
		String name,author,catagory;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Title:");
		name=sc.nextLine();
		System.out.println("Please Enter Author Name:");
		author=sc.nextLine();
		System.out.println("Please Enter catagory:");
		catagory=sc.nextLine();
		EBook obj=new EBook(name,author,catagory);
		ebooks.add(obj);
		System.out.println("Your EBook was added successfully and ID is:"+(LMS.bookId-1));
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void addPeriodical(LMS lmsobj)
	{
		String name,author,catagory;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Title:");
		name=sc.nextLine();
		System.out.println("Please Enter Author Name:");
		author=sc.nextLine();
		System.out.println("Please Enter catagory:");
		catagory=sc.nextLine();
		ePriodical obj=new ePriodical(name,author,catagory);
		eprio.add(obj);
		System.out.println("Your Periodical was added successfully and ID is:"+(LMS.bookId-1));
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void searchByName(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the text:");
		String text=sc.nextLine();
		int i,counter=0,j;
		System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("ID"));
		System.out.println();
		for(i=0;i<books.size();i++)
		{
			if(books.get(i).title.indexOf(text)>=0)
			{
				for (j=0;j<books.get(i).bookList.size();j++)
				{
					System.out.format("%10d%30s%30s%30s%30d",counter+1,books.get(i).title,books.get(i).author,books.get(i).catagory,books.get(i).bookList.get(j).uid);
					System.out.println();
					counter++;
				}
			}
		}

		for(i=0;i<ebooks.size();i++)
		{
			if(ebooks.get(i).title.indexOf(text)>=0)
			{
				for(j=0;j<ebooks.get(i).bookList.size();j++)
				{
					System.out.format("%10d%30s%30s%30s%30d",counter+1,ebooks.get(i).title,ebooks.get(i).author,ebooks.get(i).catagory,ebooks.get(i).bookList.get(j).uid);
					System.out.println();
					counter++;
				}
			}
		}

		for(i=0;i<eprio.size();i++)
		{
			if(eprio.get(i).title.indexOf(text)>=0)
			{
				for (j=0;j<eprio.get(i).bookList.size() ;j++ )
				{
					System.out.format("%10d%30s%30s%30s%30d",counter+1,eprio.get(i).title,eprio.get(i).author,eprio.get(i).catagory,eprio.get(i).bookList.get(j).uid);
					System.out.println();
					counter++;
				}
			}
		}

		if(counter==0)
			System.out.println("Sorry,No books found");
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	public void searchByAuthor(LMS lmsobj)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the text:");
		String text=sc.nextLine();
		int i,counter=0,j;
		System.out.format("%10s%30s%30s%30s%30s",new String("Serial"),new String("Title"),new String("Author"),new String("Catagory"),new String("ID"));
		System.out.println();
		for(i=0;i<books.size();i++)
		{
			if(books.get(i).author.indexOf(text)>=0)
			{
				for (j=0;j<books.get(i).bookList.size();j++)
				{
					System.out.format("%10d%30s%30s%30s%30d",counter+1,books.get(i).title,books.get(i).author,books.get(i).catagory,books.get(i).bookList.get(j).uid);
					System.out.println();
					counter++;
				}
			}
		}

		for(i=0;i<ebooks.size();i++)
		{
			if(ebooks.get(i).author.indexOf(text)>=0)
			{
				for(j=0;j<ebooks.get(i).bookList.size();j++)
				{
					System.out.format("%10d%30s%30s%30s%30d",counter+1,ebooks.get(i).title,ebooks.get(i).author,ebooks.get(i).catagory,ebooks.get(i).bookList.get(j).uid);
					System.out.println();
					counter++;
				}
			}
		}

		for(i=0;i<eprio.size();i++)
		{
			if(eprio.get(i).author.indexOf(text)>=0)
			{
				for (j=0;j<eprio.get(i).bookList.size() ;j++ )
				{
					System.out.format("%10d%30s%30s%30s%30d",counter+1,eprio.get(i).title,eprio.get(i).author,eprio.get(i).catagory,eprio.get(i).bookList.get(j).uid);
					System.out.println();
					counter++;
				}
			}
		}

		if(counter==0)
			System.out.println("Sorry,No books found");
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}
}