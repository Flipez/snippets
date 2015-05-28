from libqtile.config import Key, Screen, Group, Drag, Click
from libqtile.command import lazy
from libqtile import layout, bar, widget
from libqtile import hook

#make the cursor normal

#@hook.subscribe.startup
#def runner():
#    import subprocess
#        subprocess.Popen(['xsetroot', '-cursor_name', 'left_ptr'])

mod = "mod4"

lazy.nextlayout()
lazy.nextlayout()

keys = [
   
      # Switch between windows in current stack pane
   
	Key([mod], "k",                   lazy.layout.down()),
  Key([mod], "j",                   lazy.layout.up()),
	
      # Move windows up or down in current stack
   
	Key([mod, "control"], "k",        lazy.layout.shuffle_down()),
  Key([mod, "control"], "j",        lazy.layout.shuffle_up()),

      # Switch window focus to other pane(s) of stack
    
	Key([mod], "space",        	      lazy.layout.next()),

      # Swap panes of split stack
    
	Key([mod, "shift"], "space",      lazy.layout.rotate()),

      # Toggle between split and unsplit sides of stack.
      # Split = all windows displayed
      # Unsplit = 1 window displayed, like Max layout, but still with
      # multiple stack panes
    

	Key([mod, "shift"], "Return",     lazy.layout.toggle_split()),
  Key([mod], "Return", 		          lazy.spawn("xterm")),

    # Toggle between different layouts as defined below
    
	Key([mod], "Tab",                 lazy.nextlayout()),
  Key([mod], "w",                   lazy.window.kill()),

  Key([mod, "control"], "r",        lazy.restart()),
  Key([mod, "control"], "q",        lazy.shutdown()),
  Key([mod], "r",                   lazy.spawncmd()),

  Key([mod, "shift"], "k", lazy.layout.shuffle_down()),
  Key([mod, "shift"], "j", lazy.layout.shuffle_up()),

  Key([mod], "i", lazy.layout.grow()),
  Key([mod], "m", lazy.layout.shrink()),
  Key([mod], "n", lazy.layout.normalize()),
  Key([mod], "o", lazy.layout.maximize()),
]

groups = [Group(i) for i in "12345"]
		

for i in groups:
    # mod1 + letter of group = switch to group
    keys.append(
        Key([mod], i.name, lazy.group[i.name].toscreen())
    )

    # mod1 + shift + letter of group = switch to & move focused window to group
    keys.append(
        Key([mod, "shift"], i.name, lazy.window.togroup(i.name))
    )

layouts = [
    layout.Max(),
    layout.Stack(num_stacks=2),
    layout.MonadTall(),
]

widget_defaults = dict(
    font='Arial',
    fontsize=16,
    padding=3,
)

screens = [
    Screen(
        top=bar.Bar(
            [
                widget.GroupBox(),
                widget.Prompt(),
                widget.WindowName(),
                widget.TextBox("Pacman Updates: "),
                widget.Pacman(update_interval=30),
                widget.Sep(),
                widget.CurrentLayout(),
            ],
            30,
        ),
    ),
     Screen(
        top=bar.Bar(
            [
                widget.GroupBox(),
                widget.Prompt(),
                widget.WindowName(),
                widget.TextBox("CPU "),
                widget.CPUGraph(),
                widget.TextBox("HDD "),
                widget.HDDBusyGraph(),
                widget.TextBox("Space "),
		            widget.HDDGraph(),
                widget.TextBox("Mem "),
		            widget.MemoryGraph(),
                widget.TextBox("Net "),
		            widget.NetGraph(),
                widget.TextBox("Swap "),
		            widget.SwapGraph(),
                widget.Sep(),
                widget.CurrentLayout(),
            ],
            30,
        ),
    ),
    Screen(
        top=bar.Bar(
            [
                widget.GroupBox(),
                widget.Prompt(),
                widget.WindowName(),
                widget.Systray(),
                widget.Sep(),
		            widget.CurrentLayout(),
                widget.Sep(),
                widget.Clock(format='%d-%m-%Y %a %I:%M %p'),
            ],
            30,
        ),
    ),
]

# Drag floating layouts.
mouse = [
    Drag([mod], "Button1", lazy.window.set_position_floating(),
        start=lazy.window.get_position()),
    Drag([mod], "Button3", lazy.window.set_size_floating(),
        start=lazy.window.get_size()),
    Click([mod], "Button2", lazy.window.bring_to_front())
]

dgroups_key_binder = None
dgroups_app_rules = []
main = None
follow_mouse_focus = True
bring_front_click = False
cursor_warp = False
floating_layout = layout.Floating()
auto_fullscreen = True
wmname = "qtile"
