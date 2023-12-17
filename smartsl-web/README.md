# react-admin-template
#### TODO: Description

# Initial Set-up
- go to [react-admin-template](https://github.com/inme-digital-services/react-admin-template) and click use this template to create a new repository with this template
- clone the project and run 
    - yarn install or npm install
    - yarn start or npm start

# Folder structure inside src
### assets
<p>store media assets required for the application</p>

### components
<p>Include all the custom re-usable components here</p>

### configs
<p>App wide configurations such as</p>

- Axios
- ENVs
- firebase

### constants
<p>All the string or magic numbers are assigned to a constant or an object of constants and exported from here</p>

- API endpoints
- Config strings

### context
<p>Includes Context providers as a single store to be used in App component and Reducers ready to be used in relevant components</p>

### pages
<p>All the main page components (page layouts)</p>

### routes
<p>Main route component with route provider and all the pages mapped to routes</p>

### styles
<p>Custom scss style functions to be used later</p>

# Modules
- UI Components Library: AntDesign
- Dates: date-fns
- Testing: jest
- Routing: react-router-dom
- Validations: validate.js

# Context usage
## Create new store
### Add folder with name of the context inside the context page
#### Add index.tsx file which contains the provider of the store
~~~tsx
  interface IStoreNameContext {
      state: typeof initialState
      dispatch: Function
  }
  const StoreNameContext = createContext<IStoreNameContext>({} as IStoreNameContext)
  
  type StoreNameContextProps = {
      children: JSX.Element
  }
  export function StoreNameContextProvider({ children }: StoreNameContextProps): JSX.Element {
      const [state, dispatch] = React.useReducer(StoreNameReducer, initialState, init)
  
      return <StoreNameContext.Provider value={{ state, dispatch }} children={children} />
  }
~~~

#### Add storeNameReducer.tsx file which contains the initial state, reducer, and the useStoreNameReducer custom hook
~~~tsx
    export const initialState = {
        value: null
    }
    
    export function storeNameReduder(state: typeof initialState, {type, payload}: IActionType) {
        switch(type) {
          case ACTIONS.CHANGE_STATE:
              return {...state, value: payload}
        }
    }

    export function useStoreNameReducer() {
        const {state, dispatch} = React.useContext(storeNameContext);
    
        function changeState(updatedValues) {
            //Do something
            dispatch({type: ACTIONS.CHANGE_STATE, payload: updatedValues})
        }
        
        return {
            state,
            methods: {
                changeState
            }
        }
    }
~~~

### Add context to the store in the index.tsx file inside context folder
~~~tsx
type StoreProps = {
    children: JSX.Element
}
export default function Store({ children }: StoreProps) {
    return (
        <AuthContextProvider>
            <AppContainerProvider>
              <StoreNameContextProvider>
                {children}
              </StoreNameContextProvider>
            </AppContainerProvider>
        </AuthContextProvider>
    )
}
~~~

## Use created store inside components
- All the context stores can be accessed using useContext hook inside every child in the app
~~~tsx
export default function RandomChildComponent(props: Proptypes): JSX.Element {
    const {state, methods} = React.useContext(StoreNameContext)
  
    return (
        <div>
          <p>{state.value}</p>
          <input type="text" onChange={(event) => methods.changeState(event.target.value)}/>
        </div>
    )
}
~~~

# Unit Testing: TODO
