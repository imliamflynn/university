//
//  SeaofWordQuestion.swift
//  COSC345-Lang
//
//  Created by Mahfuz Abdul Razak on 22/09/22.
//
/*
 Generate Question Format for Sea of Words
 */

import Foundation

class SoWQuestions {
    let question: String
    let questionWord: String
    let optionA: String
    let optionB: String
    let optionC: String
    let optionD: String
    let correctAnswer: Int
    init(quest:String, questWord:String, choiceA:String, choiceB:String, choiceC:String, choiceD:String, answer:Int){
        question = quest
        questionWord = questWord
        optionA = choiceA
        optionB = choiceB
        optionC = choiceC
        optionD = choiceD
        correctAnswer = answer
    }
}
