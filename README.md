# Appdev
AppDev is android application in which authenticated users are allowded to submited application form 
and it keeps the track of number of application submitted,
number of application approved, number of application rejected and number of appplication lead generated.


Screeshots

<image src= "screenshots/Screenshot_01_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_02_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_03_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_04_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_05_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_06_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_07_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_09_App%20Dev.jpg" width = 400 height = 700>
<image src= "screenshots/Screenshot_10_Permission%20controller.jpg" width = 400 height = 700>




<table>
  <tbody>
    <tr>
      <td>Column One</td>
      <td>Column One</td>
    </tr>
    <tr>
      <td>Content of column one</td>
      <td>Content of columnt two</td>
    </tr>
  </tbody>
</table>

<!-- EXAMPLE 1: To remove the borders, you can add a style tag to the above example -->
<!-- Note the "!important" which ensures this style overrides other styles on the page! -->
<style>
  table td {
    border: none !important;
  }
</style>
<table>
  <tbody>
    <tr>
      <td>Column One</td>
      <td>Column One</td>
    </tr>
    <tr>
      <td>Content of column one</td>
      <td>Content of column two</td>
    </tr>
  </tbody>
</table>

<!-- EXAMPLE 2: Using a table id (BEST OPTION) -->
<!-- The above will have the disadvantage of affecting every single table on the page, to avoid that
     we can add an id to the table, this will also allow as to not use "!important" by increasing what's
     called the specificity of our style -->
<style>
  table#example-table td {
    border: none;
  }
</style>
<table id="example-table">
  <tbody>
    <tr>
      <td>Column One</td>
      <td>Column One</td>
    </tr>
    <tr>
      <td style="padding:10px">Content of column one adfasdf asdfasdf adfasdf adsf adsf</td>
      <td> <input type="checkbox"> -  Content of column two</td>
    </tr>
  </tbody>
</table>

<!-- EXAMPLE 3 Adjusting the style of each cell separately -->
<!-- This is perhaps the simplest of the approaches - it doesn't require a separate style tag, but it does require
    adjusting the style of every cell separately -->
<table>
  <tbody>
    <tr>
      <td style="border: none">Column One</td>
      <td style="border: none">Column One</td>
    </tr>
    <tr>
      <td style="border: none">Content of column one</td>
      <td style="border: none">Content of column two</td>
    </tr>
  </tbody>
</table>



| Item   | Description | Status |
|--------|-------------|--------|
| Task 1 | Description of Task 1 | <ul style="display:flex; color:green !important; flex-direction:row"><li>[x] item1</li><li>[ ] item2</li></ul> |
| Task 2 | Description of Task 2 | <ul><li>[x] item1</li><li>[ ] item2</li></ul> |
