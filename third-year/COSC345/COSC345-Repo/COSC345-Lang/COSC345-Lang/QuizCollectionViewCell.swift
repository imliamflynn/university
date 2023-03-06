//
//  QuizCollectionViewCell.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 24/08/22.
//

import UIKit

public enum SelectedOption {
    case optionA
    case optionB
    case optionC
    case optionD
}
/**
    Handles the selected option and highlights it so the user can tell they pressed it.
*/
public class QuizCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var option1: UILabel!
    @IBOutlet weak var option2: UILabel!
    @IBOutlet weak var option3: UILabel!
    @IBOutlet weak var option4: UILabel!
    @IBOutlet weak var optionA: UIControl!
    @IBOutlet weak var optionB: UIControl!
    @IBOutlet weak var optionC: UIControl!
    @IBOutlet weak var optionD: UIControl!
    
    private var correctAnswer: String?
    
    var setValues: Question? {
        didSet {
            questionLabel.text = setValues?.question
            option1.text = setValues?.option_1
            option2.text = setValues?.option_2
            option3.text = setValues?.option_3
            option4.text = setValues?.option_4
            correctAnswer = setValues?.correctAnswer
            
        }
    }
    /**
        Resets option borders to 0
    */
    public override func prepareForReuse() {
        updateBorder(myView: optionA)
        updateBorder(myView: optionB)
        updateBorder(myView: optionC)
        updateBorder(myView: optionD)
    }
    
    var selectedOption:((_ selectedAnswer: Bool) -> Void)?
    
    /**
        Selects option A and highlights it
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickOptionA(_ sender: Any) {
        var isCorrect = false
        if correctAnswer == setValues?.option_1 {
            isCorrect = true
        }
        selectedOption?(isCorrect)
        
        changeBorder(selectedOption: .optionA)
    }
    
    /**
        Selects option B and highlights it
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickOptionB(_ sender: Any) {
        var isCorrect = false
        if correctAnswer == setValues?.option_2 {
            isCorrect = true
        }
        selectedOption?(isCorrect)
        
        changeBorder(selectedOption: .optionB)
    }
    
    /**
        Selects option C and highlights it
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickOptionC(_ sender: Any) {
        var isCorrect = false
        if correctAnswer == setValues?.option_3 {
            isCorrect = true
        }
        selectedOption?(isCorrect)
        
        changeBorder(selectedOption: .optionC)
    }
    
    /**
        Selects option D and highlights it
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickOptionD(_ sender: Any) {
        var isCorrect = false
        if correctAnswer == setValues?.option_4 {
            isCorrect = true
        }
        selectedOption?(isCorrect)
        
        changeBorder(selectedOption: .optionD)
    }
    
    /**
        Highlights the border of the selected option
     
        - Parameters:
            - selectedOption: the answer option selected (A, B, C, D)
    */
    public func changeBorder(selectedOption: SelectedOption) {
        switch selectedOption {
        case .optionA:
            updateBorder(myView: optionA, borderWidth: 4)
            updateBorder(myView: optionB)
            updateBorder(myView: optionC)
            updateBorder(myView: optionD)
        case .optionB:
            updateBorder(myView: optionA)
            updateBorder(myView: optionB, borderWidth: 4)
            updateBorder(myView: optionC)
            updateBorder(myView: optionD)
        case .optionC:
            updateBorder(myView: optionA)
            updateBorder(myView: optionB)
            updateBorder(myView: optionC, borderWidth: 4)
            updateBorder(myView: optionD)
        case .optionD:
            updateBorder(myView: optionA)
            updateBorder(myView: optionB)
            updateBorder(myView: optionC)
            updateBorder(myView: optionD, borderWidth: 4)
        }
    }
    
    /**
        Highlights the view/option
     
        - Parameters:
            - myView: the UIView to be highlighted
            - borderWidth: 0 if not passed
    */
    public func updateBorder(myView: UIView, borderWidth: CGFloat = 0) {
        myView.layer.borderWidth = borderWidth
        myView.layer.borderColor = UIColor.white.cgColor
    }
}
