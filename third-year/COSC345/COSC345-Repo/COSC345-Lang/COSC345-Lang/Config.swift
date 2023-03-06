//
//  Config.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 16/08/22.
//

import Foundation
import UIKit

var screenWidth = UIScreen.main.bounds.size.width
var screenHeight = UIScreen.main.bounds.size.height

let tileMargin: CGFloat = 20.0

/**
    Randomly generates a number that between the two limits
    - Parameters:
        - minX: [in] lower limit of the random number
        - maxX: [in] upper limit of the random number
    - Returns:
        - Int(result): returns the randomly generated number
*/
public func randomNumber(minX: UInt32, maxX: UInt32) -> Int {
  let result = (arc4random() % (maxX - minX + 1)) + minX
  return Int(result)
}

/**
    Getter method for ScreenHeight
 */
public func getScreenWidth() -> CGFloat {
    return screenWidth
}

/**
    Setter method for ScreenWidth
     - Parameters:
         - width: [in] the width of the tile
 */
public func setScreenWidth(width: CGFloat) {
    screenWidth = width
}

/**
    Getter method for ScreenHeight
 */
public func getScreenHeight() -> CGFloat {
    return screenHeight
}

/**
    Setter method for ScreenHeight
     - Parameters:
         - height: [in] the height of the tile
 */
public func setScreenHeight(height: CGFloat) {
    screenHeight = height
}
