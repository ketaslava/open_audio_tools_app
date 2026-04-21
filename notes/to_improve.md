# Suggestions for Improvement

## VERY IMPORTANT: The "God Object" Problem (ModelData)
`ModelData` is currently doing too many things: holding UI state, acting as a navigation controller, and serving as a callback mediator for dozens of disparate actions (Save, Load, Rename, UI events).
- **Issue**: As the app grows, this file will become impossible to maintain.
- **Suggestion**: Split `ModelData` into smaller, feature-specific ViewModels or State holders (e.g., `RecorderState`, `NavigationState`, `FilesState`). Use a proper Event/Intent system instead of manual `assignCallback` methods.

## [LATER] VERY IMPORTANT: Processing Pipeline Monolith
`AudioProcessor.processData` calculates every single metric for every chunk of audio.
- **Issue**: This is extremely CPU-intensive and unnecessary if the user is only looking at one specific chart (e.g., just Pitch).
- **Suggestion**: Implement a "Pull" or "On-Demand" processing architecture. Only trigger algorithms whose outputs are currently required by the active UI page. This aligns with your goal of adding AI, which will be even more resource-heavy.

## [IGNORE] Navigation Management
The navigation is handled by a large `when` statement in `UserInterface.kt` and manual string constants.
- **Issue**: This is error-prone (typos in strings) and difficult to track as the number of pages increases.
- **Suggestion**: Use an `Enum` or `Sealed Class` for Page types. Consider using a dedicated navigation library or a simpler "Router" component to decouple page switching from the main UI structure.

## [SOLVED] Performance: Audio Data Handling
- **Fix**: Removed `MutableList` and intermediate allocations in `Recorder.kt`. Audio data is now converted from `Short` to `Float` using direct array operations.

## [IGNORE] (I think that "Service Locator" is a bad code decision) Dependency Management
Components are manually instantiated in `App.kt` and `Main.kt`.
- **Issue**: Passing 10+ parameters through every constructor (like in `Main` or `Recorder`) is hard to manage.
- **Suggestion**: Use a "Service Locator" or a DI framework. (See explanation below).

## [SOLVED] Algorithmic Efficiency
- **Fix**: Replaced the recursive FFT with a high-performance iterative Cooley-Tukey implementation that uses primitive arrays instead of objects.
