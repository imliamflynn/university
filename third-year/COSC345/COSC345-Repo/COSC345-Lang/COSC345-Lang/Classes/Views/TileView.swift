//
//  TileView.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 16/08/22.
//

import Foundation
import UIKit

/**
    Class for the tile in the Drag and Drop game
 */
public class TileView: UIImageView {
    var letter: Character
    var isMatched: Bool = false
    /**
        Init shouldnt be called and if it is diaplays the fatal error
    */
    public required init(coder aDecorder: NSCoder) {
        fatalError("use other init")
    }
    /**
        This init function displays the tile with the letter inside of it
        - Parameters:
            - Letter: [in] the string that will be displayed on the tile
            - sideLength: [in] the length of the tile
    */
    public init(letter: Character, sideLength: CGFloat) {
        self.letter = letter
        let image = UIImage(named: "tile")!
        super.init(image:image)
        let scale = sideLength / image.size.width
        self.frame = CGRect(x: 0, y: 0, width: image.size.width * scale, height: image.size.height * scale)
        
        let letterLabel = UILabel(frame:self.bounds)
        letterLabel.textAlignment = NSTextAlignment.center
        self.addSubview(letterLabel)
    }
    
    /**
        randomize() randomly tilts the tiles to give an asthetic look
     */
    public func randomize() {
        let rotation = CGFloat(randomNumber(minX: 0, maxX: 50)) / 100.0 - 0.2
        self.transform = CGAffineTransform(rotationAngle: rotation)
        let yOffset = CGFloat(randomNumber(minX: 0, maxX: 10) - 10)
        self.center = CGPoint(x: self.center.x, y: self.center.y + yOffset)
    }
}
