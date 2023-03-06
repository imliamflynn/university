//
//  QuizViewController.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 24/08/22.
//

import UIKit

/**
    The view controller for the quiz. Also generates the questions and handles the users answers too.
*/
public class QuizViewController: UIViewController {
    
    @IBOutlet weak var collectionView: UICollectionView!
    @IBOutlet weak var progressBar: UIView!
    @IBOutlet weak var scoreLabel: UILabel!
    
    var viewModel = QuestionViewModel()
    var questions: [Question] = []
    var answerSelected = false
    var isCorrectAnswer = false
    var points: Int = 0
    var index = 0
    var questionNums: [Int] = []
    
    /**
        Gets the language phrases from Phrases.plist and creates mulitple questions with answer options.
        Once generated they are then added to the collection view.
    */
    public override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        var idex = 0
        while idex < 10{
            let randy = Int.random(in:0...18)
            var dup = false

            if idex == 0{
                questionNums.append(randy)
                idex += 1
                continue
            }
            
            for numba in questionNums{
                if randy == numba{
                    dup = true
                }
            }
            if !dup{
                questionNums.append(randy)
                idex += 1
            }
        }
                
        var dex = 0
        while dex < 10 {
            if let root = NSDictionary(contentsOfFile:Bundle.main.path(forResource: "Phrases", ofType:"plist")!) as? [String:[String]] {
                
                let languageNum = MainMenu.getLanguageNum()//1 for french, 2 for spanish, 3 for maori.
                var language: String = ""
                if languageNum == 1 {
                    language = "French"
                }else if languageNum == 2 {
                    language = "Spanish"
                }else if languageNum == 3 {
                    language = "Maori"
                }
                var randAnswersFromLanguage:[String] = []
                
                for (_, phraseArray) in root {
                    randAnswersFromLanguage.append(phraseArray[languageNum])
                }
                
                let randAnswersLength = randAnswersFromLanguage.count - 1
                
                let questionNumber = questionNums[dex]
                var optionNums = [questionNumber]
                
                var idx = 1
                while idx < 4{
                    let rando = Int.random(in:0...randAnswersLength)
                    var dup = false
                    
                    for numba in optionNums{
                        if rando == numba{
                            dup = true
                        }
                    }
                    
                    if !dup{
                        optionNums.append(rando)
                        idx += 1
                    }
                }
                
                var indy = 0
                for (_, phraseArray) in root {
                    if indy == questionNumber {
                        let options = [randAnswersFromLanguage[optionNums[0]], randAnswersFromLanguage[optionNums[1]], randAnswersFromLanguage[optionNums[2]], randAnswersFromLanguage[optionNums[3]]]
                        let shuffledOptions = options.shuffled()
                        
                        let correctAnswer = phraseArray[languageNum]
                        let option_1 = shuffledOptions[0]
                        let option_2 = shuffledOptions[1]
                        let option_3 = shuffledOptions[2]
                        let option_4 = shuffledOptions[3]
                        let question = "Translate \"\(phraseArray[0])\" to \(language)"
                        
                        questions.append(Question(correctAnswer:correctAnswer, option_1:option_1, option_2:option_2, option_3:option_3, option_4:option_4, question:question))
                    }
                    indy += 1
                }
            }
            dex += 1
        }
        
        viewModel.apiToGetQuestionData {
            [weak self] in self?.questions = self!.questions
            DispatchQueue.main.async{
                self?.collectionView.delegate = self
                self?.collectionView.dataSource = self
                self?.collectionView.reloadData()
            }
        }
    }
    
    /**
        Hides navigation bar
     
        - Parameters:
            - animated: animates if bool is true
    */
    public override func viewWillAppear(_ animated: Bool) {
        self.navigationController?.setNavigationBarHidden(true, animated: false)
    }
    
    /**
        Navigates to the quiz title when pressed.
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickExit(_ sender: Any) {
        navigationController?.popToRootViewController(animated: true)
    }
    
    /**
        Goes to the next question if the user has selected an answer. Throws error if not.
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickNext(_ sender: Any) {
        if !answerSelected {
            let alert = UIAlertController(title:"Select an Option", message:"You must select an option before moving on to the next question.", preferredStyle:.alert)
            let okAction = UIAlertAction(title:"Ok", style:.default, handler: nil)
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
            
            return
        }
        answerSelected = false
        
        if isCorrectAnswer {
            points += 1
            let bigChungus = "\(points)"
            scoreLabel.text = "Score: " + bigChungus
        }
        
        if index < (self.questions.count - 1){
            index += 1
            collectionView.scrollToItem(at: IndexPath(row:index, section:0), at:.right, animated: true)
        } else {
            guard let vc = storyboard?.instantiateViewController(withIdentifier:"QuizResultViewController") as? QuizResultViewController else{return}
            vc.result = points
            HomeScreen.increaseXp(amount:points)
            self.navigationController?.pushViewController(vc, animated: true)
        }
        
        progressBar.frame.size.width = (374 / 11) * CGFloat(index + 1)
    }
}

extension QuizViewController: UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout {
    /**
        Returns number of questions.
     
        - Parameters:
            - collectionView: the collection view to be passed
            - numberOfItemsInSelection: <<
        - Returns:
            - Int: number of questions
    */
    public func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return questions.count
    }
    
    /**
        Sets up the collection view cells to be displayed correctly
     
        - Parameters:
            - collectionView: the collection view to be passed
            - indexPath: the path to the index
        - Returns:
            - UICollectionViewCell: the correctly layed out cell
    */
    public func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier:"QuizCollectionViewCell", for:indexPath) as? QuizCollectionViewCell else{
            return QuizCollectionViewCell()
        }
        cell.optionA.layer.cornerRadius = 5
        cell.optionB.layer.cornerRadius = 5
        cell.optionC.layer.cornerRadius = 5
        cell.optionD.layer.cornerRadius = 5
        cell.setValues = questions[indexPath.row]
        cell.selectedOption = {[weak self] isCorrect in
            self?.answerSelected = true
            self?.isCorrectAnswer = isCorrect
        }
        return cell
    }
    
    /**
        Returns a CGsize with collectionView width and height.
     
        - Parameters:
            - collectionView: the collection view to be passed
            - collectionViewLayout: the UICollectionViewLayout to be passed
            - indexPath: the path to the index
        - Returns:
            - CGSize: with collectionView width and height.
    */
    public func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: collectionView.frame.height)
    }
    
    /**
        Sets up the collection view cells to be displayed correctly
     
        - Parameters:
            - collectionView: the collection view to be passed
            - collectionViewLayout: the UICollectionViewLayout to be passed
            - section: section number
        - Returns:
            - CGFloat: must be 0
    */
    public func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
    /**
        Sets up the collection view cells to be displayed correctly
     
        - Parameters:
            - collectionView: the collection view to be passed
            - collectionViewLayout: the UICollectionViewLayout to be passed
            - section: section number
        - Returns:
            - CGFloat: must be 0
    */
    public func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
}
