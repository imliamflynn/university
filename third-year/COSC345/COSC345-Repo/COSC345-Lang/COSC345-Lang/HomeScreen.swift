//
//  HomeScreen.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 26/08/22.
//

import UIKit

public var totalScore: Int = 0
var xp: Int = 0
var level: Int = 1
var xpToLevelUp: Int = 5

/**
    View Controller for the Home Screen
 */
public class HomeScreen: UIViewController {
    
    @IBOutlet public weak var welcomeLabel: UILabel!
    @IBOutlet weak var levelLabel: UILabel!
    
    /**
        Loads the View Controller
     */
    public override func viewDidLoad() {
        super.viewDidLoad()
        
        welcomeLabel.text = "Welcome, " + MainMenu.getName() + "."
        
        xpToLevelUp = level * 5
        if xp >= xpToLevelUp {
            level += 1
            xp -= xpToLevelUp
        }
        
        levelLabel.text = "XP Level " + String(level) + "\nAnswer " + String(xpToLevelUp - xp) + " more questions correctly to level up!"
    }
    
    /**
     Removes the back button from the top of the view controller
     - Parameters:
      - animates: [in] gives the bool for the animation on the view controller
     */
    public override func viewWillAppear(_ animated: Bool) {
        self.navigationController?.setNavigationBarHidden(true, animated: false)
    }
    
    /**
     Gets the Users xp number
     */
    public class func getXp() -> Int {
        return xp
    }
    
    /**
     Increases xp by the amount parameter
     - Parameters:
      - amount: the amount to increase xp by
     */
    public class func increaseXp(amount: Int) {
        xp += amount
        totalScore += amount
    }
    
    /**
     Gets the users total score for the leaderboard.
     */
    public class func getScore() -> Int{
        return totalScore
    }
    
}
