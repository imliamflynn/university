//
//  SeaOfWordsTest.swift
//  COSC345-LangTests
//
//  Created by Mahfuz Abdul Razak on 30/09/22.
//

import XCTest
@testable import COSC345_Lang

public class SeaofWordsTests: XCTestCase {
    
    var seaofWordsSubject : SeaofWords!
    
    public func doesQuestionUpdate(){
        SeaofWords.setQuestionNumber(qNum: 2)
        XCTAssertEqual(SeaofWords.getQuestionNumber(), 2)
    }
    
    public func doesScoreWork(){
        SeaofWords.setScore(sc: 23)
        XCTAssertEqual(SeaofWords.getScore(), 23)

    }

    public override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    public override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }
}
