# Kotlin-Projects
Repo for learning and experiments using kotlin programming language

guess game, menebak angka 1 - 100 sederhana yang dibuat dengan menggunakan bahasa pemrograman kotlin dikala senggang  

Requirements:
- kotlin compiler
- java jdk/jre 
- javafx
  - javafx-base.jar
  - javafx-controls.jar
  - javafx-graphics.jar

compile kotlin  
*jika menggunakan jdk/jre pastikan set env JAVA_HOME ke path/to/jdk atau jre*
`kotlinc -include-runtime -d guess.jar guess.kt`

compile kotlin jika jdk tidak bundle dengan javafx dan tidak menggunakan jre  
*pastikan untuk menginstall javafx*  
`kotlinc -cp "path/to/javafx/lib/java-base.jar;path/to/javafx/lib/java-controls.jar;path/to/javafx/lib/java-graphics.jar" -include-runtime -d guess.jar guess.kt` 

jalankan game dengan `java -jar guess.jar` atau membuat executable dengan launch4j  

info: versi kotlin compile yang digunakan `1.8.21` dan javafx `javafx-sdk-17.0.8`
