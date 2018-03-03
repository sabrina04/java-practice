        /* Declare second integer, double, and String variables. */
        int j=0;
        double e = 0.0;
        String str;
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        j = scan.nextInt();
        e = scan.nextDouble();
        str = scan.nextLine(); // read rest of the thing like new line after double 
        str = scan.nextLine(); // read string
   /*     String temp="";
        while(!temp.equals("\n")){
            temp = scan.next();
            str = str.concat(" "+temp);
            System.out.println(str);
        }*/
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+j);
        /* Print the sum of the double variables on a new line. */
		System.out.println(d+e);
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s+str);
