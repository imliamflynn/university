//
//  ViewController.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 10/08/22.
//

import UIKit

class MainMenu: UIViewController {
    
    var language = ""
    var name = ""
    
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var textfield: UITextField!
    
    @IBAction func maoriButton(_ sender: Any) {
        language = "maori"
        label.text = ("Maori")
    }
    
    @IBAction func frenchButton(_ sender: Any) {
        language = "french"
        label.text = ("French")
    }
    
    @IBAction func spanishButton(_ sender: Any) {
        language = "spanish"
        label.text = ("Spanish")
    }
    
    @IBAction func startButton(_ sender: Any) {
        if let n = textfield.text, !(language.isEmpty){
            name = n
        }else{
            print("error")
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
}
