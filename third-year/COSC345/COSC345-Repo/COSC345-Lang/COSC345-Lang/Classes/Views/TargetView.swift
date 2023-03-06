//
//  TargetView.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 16/08/22.
//

import Foundation
import UIKit

/**
    Class that controlls the targets for the Drag and Drop game
 */
public class TargetView: UIImageView {
    var letter: Character
    var isMatched: Bool = false
    /**
        Init shouldnt be called and if it is diaplays the fatal error
    */
    public required init(coder aDecoder: NSCoder) {
      fatalError("use init(letter:, sideLength:")
    }
    /**
        This init function displays the empty tile that the user will drag the string into
        - Parameters:
            - Letter: [in] the string that will be dragged into it
            - sideLength: [in] the length of the tile
    */
    public init(letter: Character, sideLength: CGFloat) {
      self.letter = letter
      let image = UIImage(named: "slot")!
      super.init(image:image)
      let scale = sideLength / image.size.width
        self.frame = CGRect(x:0,y:0,width: image.size.width * scale,height: image.size.height * scale)
    }
}
