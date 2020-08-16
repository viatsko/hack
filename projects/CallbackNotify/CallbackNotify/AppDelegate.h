//
//  AppDelegate.h
//  CallbackNotify
//
//  Created by Valerii Iatsko on 25/10/15.
//  Copyright © 2015 Valerii Iatsko. All rights reserved.
//

#import <Cocoa/Cocoa.h>

@interface AppDelegate : NSObject <NSApplicationDelegate> {
    NSTimer *timer;
    NSUInteger itemsUnchecked;
}

@property (strong, nonatomic) NSStatusItem *statusBar;
@property (retain) NSTimer *timer;
@property NSUInteger itemsUnchecked;

@end

