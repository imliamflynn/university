//
//  SettingsViewController.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 22/09/22.
//

import UIKit


/**
View Controller for Settings
 */
class SettingsViewController: UIViewController {
    
    @IBOutlet weak var nameField: UITextField!
    @IBOutlet weak var langPicked: UILabel!
    @IBOutlet weak var submitButton: UIButton!
    @IBOutlet weak var backButton: UIButton!
    
    /**
     Loads the View Controller
     */
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    /**
        When the maori button is clicked it stores the language and displays it on the screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction func maoriButton(_ sender: Any) {
        MainMenu.setLanguageNum(l: 3)
        MainMenu.setLanguage(lang: "Maori")
        langPicked.text = MainMenu.getLanguage()
    }
    /**
        When the spanish button is clicked it stores the language and displays it on the screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction func spanishButton(_ sender: Any) {
        MainMenu.setLanguageNum(l: 2)
        MainMenu.setLanguage(lang: "Spanish")
        langPicked.text = MainMenu.getLanguage()
    }
    /**
        When the french button is clicked it stores the language and displays it on the screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction func frenchButton(_ sender: Any) {
        MainMenu.setLanguageNum(l: 1)
        MainMenu.setLanguage(lang: "French")
        langPicked.text = MainMenu.getLanguage()
    }
    
    /**
        When the submit button is clicked it stores the name in the textfield and goes to the next screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction func submitButton(_ sender: Any) {
        if nameField.text != ""{
            MainMenu.setName(nam: nameField.text ?? MainMenu.getName())
        }
        
        
        guard let view = storyboard?.instantiateViewController(withIdentifier:"HomeScreen") as? HomeScreen else{return}
        self.navigationController?.pushViewController(view, animated:true)
    }
    
    /**
        When the back button is clicked it goes to the previous screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction func backButtton(_ sender: Any) {
        guard let view = storyboard?.instantiateViewController(withIdentifier:"HomeScreen") as? HomeScreen else{return}
        self.navigationController?.pushViewController(view, animated:true)
    }

}
