//
//  ViewController.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 10/08/22.
//

import UIKit
import Foundation

var languageNum: Int = 0
var language = ""
var name = ""
var langSelected: Bool = false
var nameSelected: Bool = false

/**
    View Controller for the Main Menu
 */
public class MainMenu: UIViewController {
    
    /**
        Declarations for UI elements
        - Parameters:
            - label: outlet for the label
            - textfield: outlet for the textfield
            - start: outlet set for the start button
    */
    @IBOutlet public weak var label: UILabel!
    @IBOutlet public weak var textfield: UITextField!
    @IBOutlet public weak var start: UIButton!
    
    /**
        When the maori button is clicked it stores that and displays it on the screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction public func maoriButtion(_ sender: Any) {
        languageNum = 3
        language = "Maori"
        label.text = (language)
        langSelected = true
    }
    
    /**
        When the french button is clicked it stores that and displays it on the screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction public func frenchButton(_ sender: Any) {
        languageNum = 1
        language = "French"
        label.text = (language)
        langSelected = true
    }
    
    /**
        When the spanish button is clicked it stores that and displays it on the screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction public func spanishButton(_ sender: Any) {
        languageNum = 2
        language = "Spanish"
        label.text = (language)
        langSelected = true
    }
    
    /**
        When the start button is clicked the text that is entered into the textfield it stores that as the name.
        This also checks that the paramters are filled before entering the next screen
        - Parameters:
            - any: [in] allows method to be sent anything
    */
    @IBAction public func start(_ sender: Any) {
        if let nam = textfield.text {
            name = nam
            nameSelected = true
        }
        
        if nameSelected == true && langSelected == true {
            guard let view = storyboard?
                .instantiateViewController(withIdentifier:
                                            "HomeScreen") as? HomeScreen else {return}
            self.navigationController?.pushViewController(view, animated:true)
        } else {
            let alert = UIAlertController(title:"not selected", message:"Name or Language not selected", preferredStyle:.alert)
            
            let okAction = UIAlertAction(title: "Ok", style: .default, handler:nil)
            
            alert.addAction(okAction)
            
            present(alert, animated:true, completion:nil)
            return
        }
    }

    /**
        Loads the View Controller
     */
    public override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    /**
        Setter method for languageNum
     */
    public class func setLanguageNum(l:Int) {
        languageNum = l
    }
    
    /**
        Getter method for languageNum
     */
    public class func getLanguageNum() -> Int {
        return languageNum
    }
    
    /**
        Getter method for language
     */
    public class func getLanguage() -> String {
        return language
    }
    
    /**
        Setter method for language
         - Parameters:
             - lang: [in] sends the language string
     */
    public class func setLanguage(lang:String) {
        language = lang
    }
    
    /**
        Getter method for name
     */
    public class func getName() -> String {
        return name
    }
    
    /**
        Setter method for name
         - Parameters:
             - n: [in] sends the name string
     */
    public class func setName(nam:String) {
        name = nam
    }
    
    /**
        Getter method for langSelected
     */
    public class func getLangSelected() -> Bool {
        return langSelected
    }
    
    /**
        Setter method for langSelected
         - Parameters:
             - ls: [in] sends the language bool
     */
    public class func setLangSelected(lang:Bool) {
        langSelected = lang
    }
    
    /**
        Getter method for nameSelected
     */
    public class func getNameSelected() -> Bool {
        return nameSelected
    }
    
    /**
        Setter method for nameSelected
         - Parameters:
             - ns: [in] sends the name bool
     */
    public class func setNameSelected(name:Bool) {
        nameSelected = name
    }
}
