//
//  AudioController.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 16/08/22.
//

import Foundation
import AVFoundation

class AudioController {
  private var audio = [String:AVAudioPlayer]()
  
  func playEffect(name:String) {
    if let player = audio[name] {
        if player.isPlaying {
        player.currentTime = 0
      } else {
        player.play()
      }
    }
  } 
}
