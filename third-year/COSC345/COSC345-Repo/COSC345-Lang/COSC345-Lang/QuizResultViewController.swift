//
//  QuizResultViewController.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 24/08/22.
//

import UIKit

/**
    The view controller for the quiz result screen. Displays result.
*/
public class QuizResultViewController: UIViewController {
    @IBOutlet weak var resultLabel: UILabel!
    var result = 0
    /**
        Loads the view controller and sets the result label to result
    */
    public override func viewDidLoad() {
        super.viewDidLoad()
        resultLabel.text = "\(result)"
    }
    
    /**
        Navigates to the quiz title when pressed.
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickHome(_ sender: Any) {
        navigationController?.popToRootViewController(animated:true)
    }
}
