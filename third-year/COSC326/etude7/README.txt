Etude 7 - Liam Lennon-Flynn - 4239344

To Run:
Navigate to folder with files in terminal.
Type "javac *.java" and hit enter.
Then type "java Where" and hit enter.
Then copy in test cases and hit enter.
Then press control + d.


Inputs program must accept:
- Standard Form
- Standard form except the number of decimal points != 6
- Standard form except the comma is missing
- Standard form except the numbers are non-negative and are followed
  by N/S or E/W (possibly have NS/EW in the wrong order)
- "Degrees, minutes, seconds" form, with or without decimal points on the
  seconds and with or without standard marker for degrees/minutes/seconds
- Degrees and decimal minutes form



Test Cases:

90.000000, -180.000000 Dunedin1
-90.000000, 180.000000
90.000000 S, -180.000000 E Dunedin2
-90.000000 N, 180.000000 W
90.0, -180.0 Dunedin3
-90.0, 180.0
90.0 N, -180.0 E Dunedin4
-90.0 S, 180.0 W
90.000000 -180.000000 Dunedin5
-90.000000 180.000000
90.000000 S -180.000000 W Dunedin6
-90.000000 N 180.000000 E
45.3 S, 70.7 W Dunedin7
45.3 N, 70.7 E
45.3 E, 70.7 S Dunedin8
45.3 W, 70.7 N
32° 18' 23.1" 32° 18' 23.1" Dunedin9
32° 18' 23.1" 32° 18' 23.1"
32° 18' 23.1" N 32° 18' 23.1" E Dunedin10
32° 18' 23.1" S 32° 18' 23.1" W
32° 18.385' 32° 18.385' Dunedin11
32° 18.385' 32° 18.385'
32° 18.385' N 32° 18.385' E Dunedin12
32° 18.385' S 32° 18.385' W
32°18'23.1" 32°18'23.1" Dunedin13
32°18'23.1" 32°18'23.1"
32°18'23.1"S 32°18'23.1"W Dunedin14
32°18'23.1"S 32°18'23.1"W
Invalid Input
12 12 Hello 12 12 Hello
12 12 12 Test Test Test 12 12 12
45 d 52 m 1.6s S, 170 d 31 m 4.1s E OwheoTwo