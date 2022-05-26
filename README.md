# Tryhackme Anonymous Playground CTF - DecryptTool
This tool decrypts username and password for the ssh access to the virtual machine in the Tryhackme Anonymous Playground CTF Room.<br>
You can find my writeup here: https://h3l3kdh0ria.medium.com/tryhackme-anonymous-playground-ctf-writeup-e16ad917e750

# Prerequisites
I recommend to build the project with maven and execute it (See Usage)<br>
Alternatively you can import this project in a Java capable IDE of your choice, e.g. Eclipse IDE.<br>

#  Usage
## From terminal after build with maven
cd to project<br>
exec java -jar target/anonymous_playground_decrypt-[version].jar encryptedUsername::encryptedpassword<br>
## From IDE
After importing as maven project you can build and run the project with your IDE's Toolset. Please make sure to provide encrypted username and password in the format encryptedUsername::encryptedpassword as parameter.<br>


