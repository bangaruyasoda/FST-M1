"""Make a two-player Rock-Paper-Scissors game.
Remember the rules:
Rock beats scissors
Scissors beats paper
Paper beats rock"""

user1=input("Enter User1 name")
user2=input("Enter user2 name")

user1_ans = input(user1 + "Please select Rock or Paper or Scissor").lower()
user2_ans = input(user2 + "Please select Rock or Paper or Scissor").lower()
if(user1_ans==user2_ans) :
     print("Its a Tie")
elif user1_ans == 'rock':
    if user2_ans == 'paper':
     print("Paper Wins")
    else:
     print("Rock Wins")
elif user1_ans == 'scissor':
    if user2_ans=='rock':
       print("Rock Wins")
    else:
       print("Scissor Wins")
elif user1_ans == 'paper':
    if user2_ans == 'scissor' :
       print("Scissor Wins")
    else:
       print("Paper Wins")
else:
    print("Invalid input")       
   


  
   
 
    