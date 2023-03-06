//
//  Minigames.swift
//  
//
//  Created by Liam Flynn on 12/08/22.
//
import UIKit
import Foundation

/**
    View Controller for the minigames
 */
public class ViewController: UIViewController {
    var language = ""
    
    private let controller: GameController
    
    /**
        Creates an instance of the game to be played
        - Parameters:
            - NSCoder: [in]declares the interface used by concrete subclasses to transfer objects and other values between memory
    */
    public required init(coder aDecorder: NSCoder) {
        controller = GameController()
        super.init(coder:aDecorder)!
    }
    
    /**
        viewDidLoad() loads the view controller with what we want to see. In this case it loads the game and level we are playing
    */
    public override func viewDidLoad() {
      super.viewDidLoad()
        let level1 = Level(levelNumber: 1)
        print("Tower: \(level1.sentence)")
        
        super.viewDidLoad()
        let gameView = UIView(frame:CGRect(x:0, y: 0, width:screenWidth, height:screenHeight))
        self.view.addSubview(gameView)
        controller.gameView = gameView
        controller.level = level1
        controller.dealRandomSentence()
    }
}
