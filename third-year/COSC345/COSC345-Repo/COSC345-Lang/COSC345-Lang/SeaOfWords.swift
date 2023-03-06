//
//  SoWViewController.swift
//  COSC345-Lang
//
//  Created by Mahfuz Abdul Razak on 22/09/22.
//
/*
 The View Controller for Sea of Words
 */
import UIKit

let lang = MainMenu.getLanguageNum()
let allQuestions = SoWQuestionBank()
var questionNumber: Int = 0
var score: Int = 0
var selectedAnswer: Int = 0
var quest = [SoWQuestions]()

public class SeaofWords: UIViewController {
    @IBOutlet weak var questionCounter: UILabel!
    @IBOutlet weak var scoreCounter: UILabel!
    @IBOutlet weak var progressView: UIView!
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var questionWord: UILabel!
    
    //Outlet for Buttons
    @IBOutlet weak var optionA: UIButton!
    @IBOutlet weak var optionB: UIButton!
    @IBOutlet weak var optionC: UIButton!
    @IBOutlet weak var optionD: UIButton!
    
   
    
    
    public override func viewDidLoad() {
        super.viewDidLoad()
        setLanguage()
        updateQuestion()
        updateUI()
    }
    
    public override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBAction func quit(_ sender: UIButton){
        let alert = UIAlertController(title:"Are you sure you want to quit ?", message:"You will lose all progress", preferredStyle:.alert)
        let quitAction = UIAlertAction(title:"Quit", style:.default, handler:{ action in self.quitGame()})
        let cancelAction = UIAlertAction(title:"Back to Quiz", style:.cancel, handler: nil)
        alert.addAction(quitAction)
        alert.addAction(cancelAction)
        present(alert, animated: true, completion: nil)

    }
    
    
    @IBAction func answerPressed(_ sender: UIButton) {
        /*
         if sender.tag == 1 {
         print("option a")
         }else if sender.tag == 2{
         print("option b")
         }else if sender.tag == 3{
         print("option c")
         }else {
         print("option d")
         }
         */
        if sender.tag == selectedAnswer {
            print("correct")
            score += 1
        } else {
            print("wrong")
        }
        questionNumber += 1
        updateQuestion()
    }
    
    func setLanguage(){
        if lang == 1 {
            quest = allQuestions.french.shuffled()
        } else if lang == 2 {
            quest = allQuestions.list.shuffled()
        } else if lang == 3 {
            quest = allQuestions.maori.shuffled()
        }
        
    }
    
   
    
    func updateQuestion(){
            if questionNumber <= quest.count - 1{
                questionLabel.text = quest[questionNumber].question
                questionWord.text = quest[questionNumber].questionWord
                optionA.setTitle(quest[questionNumber].optionA, for: UIControl.State.normal)
                optionB.setTitle(quest[questionNumber].optionB, for: UIControl.State.normal)
                optionC.setTitle(quest[questionNumber].optionC, for: UIControl.State.normal)
                optionD.setTitle(quest[questionNumber].optionD, for: UIControl.State.normal)
                selectedAnswer = quest[questionNumber].correctAnswer
                
            }else {
                let alert = UIAlertController(title:"Awesome! You got \(score)/\(quest.count)", message:"End of Quiz. Do you want to start over?", preferredStyle:.alert)
                let restartAction = UIAlertAction(title:"Restart", style:.default, handler: {
                    action in self.restartQuiz()
                    
                })
                let goBackAction = UIAlertAction(title:"Back to Main Menu", style:.default, handler:{ action in self.finishGame()})
                alert.addAction(restartAction)
                alert.addAction(goBackAction)
                present(alert, animated: true, completion: nil)
            }
            updateUI()
    }
    
    func updateUI() {
            scoreCounter.text = "Score: \(score)"
            if questionNumber <= allQuestions.maori.count - 1{
                questionCounter.text = "\(questionNumber + 1)/\(quest.count)"
            }
        progressView.frame.size.width = (view.frame.size.width / CGFloat(quest.count)) * CGFloat(questionNumber + 1)
    }
    
    func restartQuiz(){
        score = 0
        questionNumber = 0
        updateQuestion()
        setLanguage()
    }
    
    func finishGame(){
        HomeScreen.increaseXp(amount: score)
        restartQuiz()
        self.dismiss(animated: true, completion: nil)
    }
    func quitGame(){
        restartQuiz()
        self.dismiss(animated: true, completion: nil)
    }

    
    
    public class func setQuestionNumber(qNum:Int) {
        questionNumber = qNum
    }
    
    public class func getQuestionNumber() -> Int {
        return questionNumber
    }
    
    public class func setScore(sc:Int) {
        score = sc
    }
    
    public class func getScore() -> Int {
        return score
    }
    
}
