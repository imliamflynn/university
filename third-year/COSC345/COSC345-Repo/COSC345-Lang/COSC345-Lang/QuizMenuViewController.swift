//
//  QuizMenuViewController.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 24/08/22.
//

import UIKit

/**
    The view controller for the quiz menu.
*/
public class QuizMenuViewController: UIViewController {
    @IBOutlet weak var playButton: UIButton! {
        didSet{
            playButton.layer.cornerRadius = playButton.frame.height/2
        }
    }
    @IBOutlet weak var backButton:UIButton! {
        didSet{
            backButton.layer.cornerRadius = backButton.frame.height/2
        }
    }

    /**
        Loads the view controller
    */
    public override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    /**
        Navigates to the quiz view controller when pressed.
     
        - Parameters:
            - sender: allows method to be sent anything
    */
    @IBAction public func onClickPlay(_ sender: Any) {
        guard let vc = storyboard?.instantiateViewController(withIdentifier:"QuizViewController") as? QuizViewController else {return}
        self.navigationController?.pushViewController(vc, animated: true)
    }
    
}
