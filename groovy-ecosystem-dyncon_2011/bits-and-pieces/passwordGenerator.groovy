(0..7).collect{(('a'..'z')+('A'..'Z')+(0..9))[new Random().nextInt(62)]}.join()