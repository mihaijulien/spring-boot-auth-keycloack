import { Carousel } from './components/Carousel.tsx';
import { TopBooks } from './components/TopBooks.tsx';
import { LibraryServices } from './components/LibraryService.tsx';

export const HomePage = () => {
    return (
        <>
            <TopBooks />
            <Carousel />
            <LibraryServices />
        </>
    )
}