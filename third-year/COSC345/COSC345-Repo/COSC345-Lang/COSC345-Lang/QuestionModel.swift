//
//  QuestionModel.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 23/08/22.
//

import Foundation

struct DataModel: Codable {
    var data:QuestionModel?
}

struct QuestionModel: Codable {
    var questions:[Question]?
}
    
struct Question: Codable {
    var correctAnswer: String?
    var option_1: String?
    var option_2: String?
    var option_3: String?
    var option_4: String?
    var question: String?
    
    init(correctAnswer:String, option_1:String, option_2:String, option_3:String, option_4:String, question:String) {
        self.correctAnswer = correctAnswer
        self.option_1 = option_1
        self.option_2 = option_2
        self.option_3 = option_3
        self.option_4 = option_4
        self.question = question
      }
}
