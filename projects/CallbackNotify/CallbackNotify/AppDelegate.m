//
//  AppDelegate.m
//  CallbackNotify
//
//  Created by Valerii Iatsko on 25/10/15.
//  Copyright © 2015 Valerii Iatsko. All rights reserved.
//

#import "AppDelegate.h"

@interface AppDelegate ()

@property (weak) IBOutlet NSWindow *window;
@property (weak) IBOutlet NSMenu *menu;

@end

@implementation AppDelegate

@synthesize statusBar = _statusBar;
@synthesize timer;
@synthesize itemsUnchecked;

- (void) awakeFromNib {
    // Creating status bar
    self.statusBar = [[NSStatusBar systemStatusBar] statusItemWithLength:NSVariableStatusItemLength];
    
    self.statusBar.title = @"C";
    
    self.statusBar.highlightMode = YES;
    
    self.statusBar.menu = self.menu;
    
    // Checking json every 30 seconds
    self.timer = [NSTimer scheduledTimerWithTimeInterval:15 target:self selector:@selector(updateList) userInfo:nil repeats:YES];
    
    // NSRunLoop.currentRunLoop().addTimer(yourTimer, forMode: NSRunLoopCommonModes) ??
    
    // Do a first json fetch right away
    [self.timer fire];
}

- (void) updateList {
    // Request
    NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:@"https://koroboost.com/callback/callback.json"]];
    
    NSData *response = [NSURLConnection sendSynchronousRequest:request returningResponse:nil error:nil];

    // If we are on mobile network, response might fail, but discover it silently.
    if (response) {
        NSError *jsonParsingError = nil;
        
        // JSON parse
        NSArray *callbacksList = [NSJSONSerialization JSONObjectWithData:response options:0 error:&jsonParsingError];
        
        // Counting newItems for changing menu title
        NSUInteger newItems = 0;
        
        NSMutableArray *currentItems = [[NSMutableArray alloc] init];
        
        NSArray *menuArray = [self.menu itemArray];
        
        for (NSMenuItem *menuItem in menuArray) {
            [currentItems addObject:menuItem.title];
        }
        
        if (jsonParsingError) {
            [NSApp presentError:jsonParsingError];
        } else {
            // Selecting maximum 10 elements
            NSUInteger callbacksCount = [callbacksList count];
            for (int i = 0; i < (callbacksCount > 10 ? 10 : callbacksCount); i++) {
                NSDictionary *uniqObject = callbacksList[i];

                NSString *date = uniqObject[@"date"];
                NSString *type = uniqObject[@"type"];
                NSString *number = uniqObject[@"number"];
                NSString *comment = uniqObject[@"comment"];

                NSString *itemTitle = [NSString stringWithFormat:@"%@ %@ %@ %@", date, number, type, comment];
                
                if (![currentItems containsObject:itemTitle]) {            
                    newItems++;

                    NSMenuItem *menuItem = [[NSMenuItem alloc] initWithTitle:itemTitle action:@selector(itemClicked:) keyEquivalent:@""];
                    
                    [menuItem setRepresentedObject:number];
                    
                    [self.menu insertItem:menuItem atIndex:0];
                }
            }
        }
        
        self.itemsUnchecked += newItems;
        
        [self updateAppTitle];
    }
}

- (void) updateAppTitle {
    if (self.itemsUnchecked > 0) {
        [self.statusBar setTitle:[NSString stringWithFormat:@"C %lu", (unsigned long)self.itemsUnchecked]];
    } else {
        [self.statusBar setTitle:@"C"];
    }
}

- (BOOL) writeToPasteBoard:(NSString *)stringToWrite {
    NSPasteboard *pasteBoard = [NSPasteboard generalPasteboard];
    
    [pasteBoard declareTypes:[NSArray arrayWithObject:NSStringPboardType] owner:nil];
    
    return [pasteBoard setString:stringToWrite forType:NSStringPboardType];
}

- (void)itemClicked:(id)sender {
    NSMenuItem *menuItem = sender;
    
    [menuItem setEnabled:NO];
    
    self.itemsUnchecked--;
    
    [self writeToPasteBoard:[menuItem representedObject]];
    
    [self updateAppTitle];
}

// Mark All as Read button
- (IBAction)markAction:(id)sender {
    NSArray *menuArray = [self.menu itemArray];
    
    for (int i = 0; i < [menuArray count] - 4; i++) {
        [[self.menu itemAtIndex:i] setEnabled:NO];
    }
    
    self.itemsUnchecked = 0;
    
    [self updateAppTitle];
}

// Quit button
- (IBAction)quitAction:(id)sender {
    [[NSApplication sharedApplication] terminate:nil];
}

- (void)applicationDidFinishLaunching:(NSNotification *)aNotification {
    
}

- (void)applicationWillTerminate:(NSNotification *)aNotification {
    // Insert code here to tear down your application
}

@end
